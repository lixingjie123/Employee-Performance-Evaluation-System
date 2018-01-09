package com.epes.demo.controller;

import com.epes.demo.entity.SusersDO;
import com.epes.demo.service.IdService;
import com.epes.demo.service.SusersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * @author lixingjie
 * Date: 2018-01-05
 * Time: 15:39
 */

@Controller
public class TestController {

    @Autowired
    private SusersService susersService;
    private IdService idService = new IdService();


    @GetMapping(value = "/index",produces = "text/plain;charset=utf-8")
    public String hello(){
        String id = idService.getIDToHexString();
        System.out.println(id);
        return "login";
    }

    @GetMapping(value = "/findAllUsers")
    @ResponseBody
    public List<SusersDO> findAllUsers(){
        List<SusersDO> users = susersService.findAllUsers();
        return users;
    }

    @GetMapping(value = "/insertUser",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String insertUser(SusersDO user){
        Map<String, String> map = susersService.addUser(user);
        return map.get("message");
    }

}

