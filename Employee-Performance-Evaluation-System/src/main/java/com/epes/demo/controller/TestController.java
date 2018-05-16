package com.epes.demo.controller;


import com.epes.demo.entity.UserInfo;
import com.epes.demo.service.UserInfoService;
import com.epes.demo.tool.SearchParams;
import com.epes.demo.tool.exception.NotTableEntityException;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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


/***
 * 跨域请求处理（允许来自http://localhost:8081的跨域请求）
 */
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@Controller
public class TestController {

    @Autowired
    private UserInfoService userInfoService;

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



/*    @GetMapping(value = "/findAllUsers")
    @ResponseBody
    public String  findAllUsers(HttpServletRequest request, HttpServletResponse response) throws NoSuchFieldException, IllegalAccessException {
        Gson gson = new Gson();
        PageRequest pageRequest = new PageRequest(0,10);
        SearchParams searchParams = new SearchParams();
        List<Map<String, Object>> susers = userInfoService.findAllUsers(pageRequest,searchParams);
        String data = gson.toJson(susers);
        return data;
    }*/
/*
    @GetMapping(value = "/redis")
    @Cacheable(value = "suser")
    @ResponseBody
    public UserInfo redis(){
        UserInfo userInfo = userInfoService.findById("cba9e2740c3249c7b8a0ad18260487d5");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return userInfo;
    }*/

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

