package com.epes.demo.controller;

import com.epes.demo.entity.Department;
import com.epes.demo.entity.UserInfo;
import com.epes.demo.entity.UserLogin;
import com.epes.demo.service.DepartmentService;
import com.epes.demo.service.UserInfoService;
import com.epes.demo.service.UserLoginService;
import com.epes.demo.tool.Encryption;
import com.epes.demo.tool.SearchParams;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Date: 2018/4/23
 * Time: 22:36
 *
 * @Author lixingjie
 * @Modifice
 */

@Controller
@RequestMapping(value = "/UserInfo")
public class UserController {

    private final UserInfoService userInfoService;
    private final UserLoginService userLoginService;
    public final DepartmentService departmentService;

    @Autowired
    public UserController(UserInfoService userInfoService, UserLoginService userLoginService, DepartmentService departmentService) {
        this.userInfoService = userInfoService;
        this.userLoginService = userLoginService;
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/findAllUser")
    @ResponseBody
    public List<UserInfo> findAllUser(){
        return userInfoService.findAllUsers();
    }

    @PostMapping(value = "/findUserBypage")
    @ResponseBody
    public String findUserBypage(int pageIndex, int size, SearchParams search){
        PageRequest pageRequest = new PageRequest(pageIndex,size);
        List<Map<String, Object>> response = userInfoService.findAllUsers(pageRequest, search);
        List<Department> depts = departmentService.findAllDept();
        for (Map<String, Object> user : response){
            String deptid = user.get("deptid").toString();
            for (int i = 0; i<depts.size();i++){
                if (deptid.equals(depts.get(i).getId())){
                    user.put("deptName", depts.get(i).getName());
                }
            }
        }
        Gson gson = new Gson();
        return gson.toJson(response);
    }

    @PostMapping(value = "/resetPassword")
    @ResponseBody
    public Map<String,String> resetPassword(String id){
        String msg = userLoginService.resetPassword(id);
        Map<String,String> data = new HashMap<>(0);
        data.put("msg",msg);
        return data;
    }

    @PostMapping(value = "/deleteUser")
    @ResponseBody
    public Map<String, String> deleteUser(String id){
        return userInfoService.deleteUser(id);
    }

    @PostMapping(value = "/findUserById")
    @ResponseBody
    public UserInfo findUserById(String id){
        return userInfoService.findUser(id);
    }

    @PostMapping(value = "/updateUserinfo")
    @ResponseBody
    public Map<String, String> updateUserinfo(UserInfo request){
        return userInfoService.updataUser(request);
    }

    @PostMapping(value = "/addUser")
    @ResponseBody
    public Map<String, String> addUser(UserInfo request){
        return userInfoService.addUser(request);
    }
}
