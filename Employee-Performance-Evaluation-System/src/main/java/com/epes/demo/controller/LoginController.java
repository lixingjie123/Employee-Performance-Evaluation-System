package com.epes.demo.controller;

import com.epes.demo.service.SusersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

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
    private final SusersService susersService;

    @Autowired
    public LoginController(SusersService susersService) {
        this.susersService = susersService;
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> login(HttpSession request, String loginname, String password){
        Map<String,Object> map = new HashMap<>(0);
        try {
            map = susersService.login(loginname,password);
        } catch (NoSuchAlgorithmException e) {
            logger.error("登陆时，密码加密摘要算法不支持");
            e.printStackTrace();
        }
        request.setAttribute("userinfo",map.get("userinfo"));
        return map;
    }
}
