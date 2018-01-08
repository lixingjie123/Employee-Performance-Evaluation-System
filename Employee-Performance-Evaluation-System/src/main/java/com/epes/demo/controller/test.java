package com.epes.demo.controller;

import com.epes.demo.entity.Susers;
import java.util.*;
import com.epes.demo.service.IDService;
import com.epes.demo.service.SusersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: lixingjie
 * Date: 2017-12-07
 * Time: 9:45
 */

@Controller
public class test {

    @Autowired
    private SusersService susersService;
    private  IDService idService = new IDService();


    @GetMapping(value = "/index",produces = "text/plain;charset=utf-8")
    public String hello(){
        String id = idService.getIDToHexString();
        System.out.println(id);
        return "login";
    }

    @GetMapping(value = "/findAllUsers")
    @ResponseBody
    public List<Susers> findAllUsers(){
        List<Susers> users = susersService.findAllUsers();
        return users;
    }

    @GetMapping(value = "/insertUser",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String insertUser(Susers user){
        Map<String, String> map = susersService.addUser(user);
        return map.get("message");
    }

}
