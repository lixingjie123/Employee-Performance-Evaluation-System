package com.epes.demo.service;

import com.epes.demo.dao.SuserDao;
import com.epes.demo.entity.Suser;
import com.epes.demo.tool.Encryption;
import com.epes.demo.tool.exception.ColumnIsNullException;
import com.epes.demo.tool.exception.NotTableEntityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;



/**
 * Created with IntelliJ IDEA.
 * Description:
 * @author lixingjie
 * Date: 2018-01-05
 * Time: 15:39
 */
@Transactional(rollbackFor = {})
@Service
public class SusersService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private IdService idService = new IdService();

    private final SuserDao susersMapper;
    private final BaseService baseService;

    @Autowired
    public SusersService(SuserDao susersMapper, BaseService baseService) {
        this.susersMapper = susersMapper;
        this.baseService = baseService;
    }


    /**
     * 创建用户
     * @param u
     * @return
     */
    public Map<String ,String> addUser(Suser u) throws NoSuchAlgorithmException {
        Map<String , String> map = new HashMap<>(0);
        u.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        // 对密码进行加密
        u.setPassword(Encryption.encoder(u.getPassword(),Encryption.SHA1));
        String loginname = susersMapper.queryByLoginName(u.getLoginName());
        if (loginname == null || "".equals(loginname)){
            try {
                baseService.insert(u);
                map.put("message","成功");
            } catch (NotTableEntityException | ColumnIsNullException | IllegalAccessException e) {
                map.put("message", e.getMessage());
            }
        }else {
            map.put("message","用户名已存在");
        }
        return map;
    }

    /**
     * 修改用户个人信息
     * @param suser
     * @return
     */
    public Map<String,String> updataUser(Suser suser){
        Map<String, String> map = new HashMap<>(0);
        try {
            int p = baseService.updata(suser);
            if (p>0){
                map.put("message","修改成功");
            }else {
                map.put("message","数据不存在或数据无法修改");
            }
        } catch (NotTableEntityException | ColumnIsNullException | IllegalAccessException e) {
            map.put("message", e.getMessage());
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 查找所有用户
     * @return
     */
    public List<Suser> findAllUsers() {
        return susersMapper.findAllUser();
    }

    public Map<String,String> deleteUser(String id){
        Map<String, String> map = new HashMap<>(0);
        int p = baseService.delete(Suser.class, id);
        if (p>0){
            map.put("message","删除成功");
        }else {
            map.put("message","该数据不存在");
        }
        return map;
    }

    public Map<String, Object> login(String loginname,String password) throws NoSuchAlgorithmException {
        password = Encryption.encoder(password, Encryption.SHA1);
        int p = 0;
        Map<String, Object> result = new HashMap<String, Object>();
        Suser suser = susersMapper.login(loginname,password);
        if (suser != null) {
            p = 1;
            result.put("success","登陆成功！");
        } else {
            result.put("error","账户或密码错误！");
        }
        result.put("userinfo",suser);
        result.put("p", p);
        return result;
    }

    public Suser findById(String id){
        return susersMapper.findById(id);
    }
}
