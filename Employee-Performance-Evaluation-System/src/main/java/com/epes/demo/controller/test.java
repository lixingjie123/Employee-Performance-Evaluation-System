package com.epes.demo.controller;

import com.epes.demo.entity.Susers;
import com.epes.demo.mapper.SusersMapper;
import com.epes.demo.service.IDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    private final SusersMapper susersMapper;
    private  IDService idService = new IDService();

    @Autowired
    public test(SusersMapper susersMapper) {
        this.susersMapper = susersMapper;
    }


    @GetMapping(value = "/index",produces = "text/plain;charset=utf-8")
    public String hello(){
        String id = idService.getIDToHexString();
        System.out.println(id);
        return "login";
    }

    @GetMapping(value = "/findAllUsers")
    @ResponseBody
    public List<Susers> findAllUsers(){
        List<Susers> users = susersMapper.findAll();
        return users;
    }

}
