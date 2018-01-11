package com.epes.demo.service;

import com.epes.demo.entity.Suser;
import com.epes.demo.dao.SuserDao;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * @author lixingjie
 * Date: 2018-01-05
 * Time: 15:39
 */
@Transactional()
@Service
public class SusersService {
    private final SuserDao susersMapper;

    @Autowired
    public SusersService(SuserDao susersMapper) {
        this.susersMapper = susersMapper;
    }


    /**
     * 创建用户
     * @param u
     * @return
     */
    public Map<String ,String> addUser(Suser u){
        Map<String , String> map = new HashMap<>(0);
        u.setId(UUID.randomUUID().toString().replaceAll("-", ""));
       int p = 0;
        p = susersMapper.insertUser(u);
        if (p > 0){
            map.put("message","创建成功");
        }
        return map;
    }

    /**
     * 查找所有用户
     * @return
     */
    public List<Suser> findAllUsers(){
        return susersMapper.findAllUser();
    }
}
