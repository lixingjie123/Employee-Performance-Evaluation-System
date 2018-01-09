package com.epes.demo.service;

import com.epes.demo.entity.SusersDO;
import com.epes.demo.dao.SusersDao;
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
    private final SusersDao susersMapper;

    @Autowired
    public SusersService(SusersDao susersMapper) {
        this.susersMapper = susersMapper;
    }


    /**
     * 创建用户
     * @param u
     * @return
     */
    public Map<String ,String> addUser(SusersDO u){
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
    public List<SusersDO> findAllUsers(){
        return susersMapper.findAllUser();
    }
}
