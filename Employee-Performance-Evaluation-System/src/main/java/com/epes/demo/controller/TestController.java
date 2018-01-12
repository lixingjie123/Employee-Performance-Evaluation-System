package com.epes.demo.controller;


import com.epes.demo.entity.Suser;
import com.epes.demo.service.BaseService;
import com.epes.demo.service.IdService;
import com.epes.demo.service.SusersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

@Controller
public class TestController {

    @Autowired
    private SusersService susersService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/login")
    @ResponseBody
    public Map<String,Object> login(){
        //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
        Map<String,Object> map =new HashMap<String,Object>(0);
        return map;
    }

    @GetMapping(value = "/index",produces = "text/plain;charset=utf-8")
    public String hello(){
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(id);
        return "login";
    }

    @GetMapping(value = "/findAllUsers")
    @ResponseBody
    public List<Suser> findAllUsers() throws NoSuchFieldException, IllegalAccessException {
        return susersService.findAllUsers();
    }

    @GetMapping(value = "/insertUser",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String insertUser() throws NoSuchFieldException {
        Suser suser= new Suser();
        suser.setAdd("渝北");
        suser.setName("张三");
        suser.setRole(1);
        suser.setAge(21);
        Map<String, String> map = susersService.addUser(suser);
        return map.get("message");
    }

}

