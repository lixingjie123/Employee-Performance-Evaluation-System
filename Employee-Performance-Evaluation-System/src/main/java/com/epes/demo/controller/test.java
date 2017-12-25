package com.epes.demo.controller;

import com.epes.demo.model.ClientProperties;
import com.epes.demo.model.Users;
import com.epes.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private final ClientProperties clientProperties;
    private final UsersRepository usersRepository;

    @Autowired
    public test(ClientProperties clientProperties, UsersRepository usersRepository) {
        this.clientProperties = clientProperties;
        this.usersRepository = usersRepository;
    }

    @GetMapping(value = "{id}/index",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String hello(@PathVariable("id") Integer id,String name){
        System.out.println("已经到达后台"+"  "+name);
        return "indexID:"+id+" 名字:"+name;
    }

    @GetMapping(value = "/findAllUsers")
    @ResponseBody
    public List<Users> findAllUsers(){
        return usersRepository.findAll();
    }


}
