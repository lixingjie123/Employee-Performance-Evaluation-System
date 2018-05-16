package com.epes.demo.service;

import com.epes.demo.dao.*;
import com.epes.demo.entity.*;
import com.epes.demo.tool.Encryption;
import com.epes.demo.tool.SearchParams;
import com.epes.demo.tool.exception.NotTableEntityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * @author lixingjie
 * Date: 2018-01-05
 * Time: 15:39
 */
@Transactional(rollbackFor = {})
@Service
public class UserInfoService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private IdService idService = new IdService();

    private final UserInfoDao userInfoDao;
    private final BaseService baseService;
    private final UserLoginDao userLoginDao;
    private final UserRoleDao userRoleDao;
    private final RolePermissionDao rolePermissionDao;
    private final ApplicationDao applicationDao;

    @Autowired
    public UserInfoService(UserInfoDao userInfoDao, BaseService baseService, UserLoginDao userLoginDao, RolePermissionDao rolePermissionDao, UserRoleDao userRoleDao, ApplicationDao applicationDao) {
        this.userInfoDao = userInfoDao;
        this.baseService = baseService;
        this.userLoginDao = userLoginDao;
        this.rolePermissionDao = rolePermissionDao;
        this.userRoleDao = userRoleDao;
        this.applicationDao = applicationDao;
    }


    /**
     * 创建用户
     *
     */
    @Transactional
    public Map<String, String> addUser(List<UserInfo> userList) {
        Map<String, String> response = new HashMap<>(0);
        StringBuilder msg = new StringBuilder();
        for (UserInfo user: userList) {
            user.setId(UUID.randomUUID().toString());
            UserLogin userLogin = new UserLogin();
            byte[] src = new byte[0];
            try {
                src = Encryption.encoderByMd5("123456a");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            userLogin.setPassword(Encryption.ToHexString(src));
            userLogin.setId(user.getId());
            int i = baseService.insert(user);
            int p = baseService.insert(userLogin);
            if (i > 0 && p > 0){
                msg.append("用户：").append(user.getName()).append("添加成功；");
            }
        }
        response.put("msg",msg.toString());
        return response;
    }

    /**
     * 创建用户
     *
     */
    @Transactional
    public Map<String, String> addUser(UserInfo user) {
        Map<String, String> response = new HashMap<>(0);
        String msg = "添加失败";
        String success = "error";
        user.setId(UUID.randomUUID().toString());
        UserLogin userLogin = new UserLogin();
        byte[] src = new byte[0];
        try {
            src = Encryption.encoderByMd5("123456a");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        userLogin.setPassword(Encryption.ToHexString(src));
        userLogin.setId(user.getId());
        int i = baseService.insert(user);
        baseService.insert(userLogin);
        if (i > 0 ){
            msg = "添加成功；";
            success = "success";
        } else {
            msg = "添加用户失败,请检查信息类型是否正确！";
        }
        response.put("msg",msg);
        response.put("success",success);
        return response;
    }

    /**
     * 修改用户个人信息
     * @param userInfo
     * @return
     */
    @Transactional
    public Map<String,String> updataUser(UserInfo userInfo){
        Map<String, String> map = new HashMap<>(0);
        int p = baseService.update(userInfo);
        if (p>0){
            map.put("msg","修改成功");
            map.put("success","success");
        }else {
            map.put("msg","数据不存在或数据无法修改");
            map.put("success","error");
        }
        return map;
    }

    /**
     * 查找所有用户
     * @return
     */
    public List<Map<String, Object>> findAllUsers(PageRequest pageRequest, SearchParams searchParams) {
        List<Map<String, Object>> susers = baseService.pageFindByCondition(UserInfo.class,pageRequest,searchParams);
        return susers;
    }

    public List<UserInfo> findAllUsers(){
        return userInfoDao.findAllUser();
    }

    /**
     * 删除用户
     */
    @Transactional
    public Map<String,String> deleteUser(String id) {
        Map<String, String> map = new HashMap<>(0);
        int p = baseService.delete(UserInfo.class, id);
        if (p>0){
            baseService.delete(UserLogin.class,id);
            map.put("msg","删除成功");
            map.put("success","success");
        }else {
            map.put("msg","该数据不存在");
            map.put("success","error");
        }
        return map;
    }

    /**
     * 查询单个用户
     */
    public UserInfo findUser(String id){
        return userInfoDao.findUser(id);
    }


    /**
     * 登陆功能
     * @param loginname
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     */
    @Transactional
    public Map<String, Object> login(String loginname,String password){
        // 加密密码
        try {
            password = Encryption.encoder(password, Encryption.MD5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Map<String, Object> result = new HashMap<String, Object>();
        // 通过登录名获取用户信息
        UserInfo userInfo = userInfoDao.findUserByLoginName(loginname);
        if (userInfo != null) {
            // 获取用户ID
            String userid = userInfo.getId();
            // 获取用户密码
            String uPassword = userLoginDao.findUserId(userid);
            // 对比用户密码
            if (uPassword.equals(password)){
                result.put("userid",userInfo.getId());
                result.put("msg","登陆成功！");
                result.put("success","success");
            } else {
                result.put("msg","账户或密码错误！");
                result.put("success","error");
            }
        } else {
            result.put("error","账户或密码错误！");
            result.put("success","error");
        }
        return result;
    }

    /** 获取权限
     * @param userid
     * @return
     */
    public Set<Application> getApp(String userid){
        // 获取用户角色信息
        List<UserRole> roles = userRoleDao.findUserRole(userid);
        List<RolePermission> permissions = new ArrayList<>();
        List<Application> applications = new ArrayList<>();
        // 获取角色权限
        for (UserRole role : roles) {
            List<RolePermission> permission = rolePermissionDao.findRolePerByRid(role.getRoleid());
            permissions.addAll(permission);
        }
        for (RolePermission rolePermission : permissions){
            Application application = new Application();
            if (rolePermission.getApp_id()!=null) {
                application = applicationDao.findAppById(rolePermission.getApp_id());
            }
            if (application != null){
                applications.add(application);
            }
        }
        return new HashSet<>(applications);
    }
}
