package com.epes.demo.controller;

import com.epes.demo.entity.Application;
import com.epes.demo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.*;

/**
 * Description:
 * Date: 2018/1/17
 * Time: 11:32
 *
 * @Author lixingjie
 * @Modifice
 */

@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserInfoService userInfoService;

    @Autowired
    public LoginController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping(value = "/",produces = "text/plain;charset=utf-8")
    public String hello(){
        return "login";
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> login(String loginname,String password,HttpSession session){
        Map<String, Object> respons = userInfoService.login(loginname,password);
        session.setAttribute("userid", respons.get("userid"));
        return respons;
    }

    @PostMapping(value = "/getApp")
    @ResponseBody
    public Set<Application> getApp(String userid){
        return userInfoService.getApp(userid);
    }
/*
    @PostMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> login(HttpSession request, String loginname, String password){
        Map<String,Object> map = new HashMap<>(0);
        try {nname,password);
        } catch (NoSuchAlgorithmException e)
            map = userInfoService.login(logi {
            logger.error("登陆时，密码加密摘要算法不支持");
            e.printStackTrace();
        }
        request.setAttribute("userinfo",map.get("userinfo"));
        return map;
    }*/
}
