package com.epes.demo.controller;


import com.epes.demo.entity.Suser;
import com.epes.demo.service.SusersService;
import com.epes.demo.tool.exception.NotTableEntityException;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

@Controller
public class TestController {

    @Autowired
    private SusersService susersService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/PrintLog")
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
        return "login";
    }

    @GetMapping(value = "/findAllUsers")
    @ResponseBody
    public String  findAllUsers(HttpServletRequest request, HttpServletResponse response) throws NoSuchFieldException, IllegalAccessException {
        String callback = request.getParameter("callback");
        Gson gson = new Gson();
        List<Suser> susers = susersService.findAllUsers();
        String data = gson.toJson(susers);
        if(callback != null && !"".equals(callback)){
            data = callback + "("+data+")";
        }
        return data;
    }

    @GetMapping(value = "/insertUser",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String insertUser() throws NoSuchFieldException {
        Suser suser= new Suser();
        suser.setAddress("渝北");
        suser.setUname("张三");
        suser.setRole(1);
        suser.setAge(21);
        suser.setLoginName("lixingjie3");
        suser.setPassword("lixingjie");
        suser.setSex("男");
        Map<String, String> map = new HashMap<>(0);
        try {
            map = susersService.addUser(suser);
        } catch (NoSuchAlgorithmException e) {
            logger.error("用户创建时，密码加密摘要不支持");
        }
        return map.get("message");
    }

    @GetMapping(value = "/updateUser",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updateUser() throws NoSuchFieldException {
        Suser suser= new Suser();
        suser.setPhone("18920441234");
        suser.setId("a2142d4491dc4d98b862aeaf7db434bb");
        Map<String, String> map = susersService.updataUser(suser);
        return map.get("message");
    }

    @GetMapping(value = "/deleteUser",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String deleteUser(){
        Map<String, String> map = new HashMap<>(0);
        try {
            map = susersService.deleteUser("3c8b5de618d347b1bb22c2e13b70fe1d");
        } catch (NotTableEntityException e) {
            e.printStackTrace();
        }
        return map.get("message");
    }

    @GetMapping(value = "/redis")
    @Cacheable(value = "suser")
    @ResponseBody
    public Suser redis(){
        Suser suser = susersService.findById("cba9e2740c3249c7b8a0ad18260487d5");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return suser;
    }

    @GetMapping(value = "/session")
    @ResponseBody
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

    @GetMapping(value = "/toMain")
    public String toMain(HttpSession session){
        System.out.println(session.getAttribute("userinfo").toString());
        return "index";
    }
}

