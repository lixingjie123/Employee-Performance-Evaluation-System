package com.epes.demo.service;

import com.epes.demo.dao.DepartmentDao;
import com.epes.demo.dao.UserInfoDao;
import com.epes.demo.entity.Department;
import com.epes.demo.entity.UserInfo;
import com.epes.demo.tool.SearchParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Description:
 * Date: 2018/4/17
 * Time: 10:55
 *
 * @Author lixingjie
 * @Modifice
 */
@Transactional
@Service
public class DepartmentService {

    private final BaseService baseService;

    private final DepartmentDao departmentDao;
    private final UserInfoDao userInfoDao;

    @Autowired
    public DepartmentService(BaseService baseService, DepartmentDao departmentDao, UserInfoDao userInfoDao) {
        this.baseService = baseService;
        this.departmentDao = departmentDao;
        this.userInfoDao = userInfoDao;
    }

    /**
     * 添加部门
     * @param department
     * @return
     */
    @Transactional
    public Map<String, String> addDepartment(Department department){
        Map<String, String> result = new HashMap<>(0);
        department.setId(UUID.randomUUID().toString());
        int i = baseService.insert(department);
        if (i>0){
            result.put("success","success");
            result.put("msg","新增成功");
        }else {
            result.put("success","error");
            result.put("msg","新增失败,无法连接数据库");
        }
        return result;
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @Transactional
    public Map<String, String> delete(String id){
        Map<String, String> result = new HashMap<>(0);
        int i = baseService.delete(Department.class,id);
        if (i>0){
            result.put("success","success");
            result.put("msg","删除成功");
        }else {
            result.put("success","error");
            result.put("msg","删除失败,无法连接数据库");
        }
        return result;
    }

    /**
     * 修改部门
     * @param department
     * @return
     */
    @Transactional
    public Map<String, String> update(Department department){
        int p = baseService.update(department);
        Map<String,String> map = new HashMap<>(0);
        if (p>0){
            map.put("msg","修改成功");
            map.put("success","success");
        }else {
            map.put("msg","数据不存在或数据无法修改");
            map.put("success","error");
        }
        return map;
    }

    public Department findDeptById(String id){
        Department department = departmentDao.findDept(id);
        if (!"".equals(department.getUserid()) && department.getUserid() != null){
            String userid = department.getUserid();
            UserInfo user = userInfoDao.findUser(userid);
            department.setUserName(user.getName());
            department.setUserCode(user.getCode());
        }
        return department;
    }

    @Transactional
    public List<Map<String, Object>> findAllByPage(PageRequest pageRequest, SearchParams searchParams){
        List<Map<String, Object>> response = baseService.pageFindByCondition(Department.class, pageRequest, searchParams);
        for (Map<String, Object> dept : response){
            if (!"".equals(dept.get("userid")) && dept.get("userid") != null){
                String userid = dept.get("userid").toString();
                UserInfo user = userInfoDao.findUser(userid);
                if(user != null){
                    dept.put("userName",user.getName());
                    dept.put("userPhone",user.getPhone());
                }

            }
        }
        return response;
    }

    public List<Department> findAllDept(){
        return departmentDao.findAllDept();
    }
}
