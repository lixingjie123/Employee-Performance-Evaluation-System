package com.epes.demo.service;

import com.epes.demo.entity.Suser;
import com.epes.demo.dao.SuserDao;
import java.util.*;

import com.epes.demo.tool.exception.ColumnIsNullException;
import com.epes.demo.tool.exception.NotTableEntityException;
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
@Transactional(rollbackFor = {})
@Service
public class SusersService {
    private IdService idService = new IdService();

    private final SuserDao susersMapper;
    private final BaseService baseService;

    @Autowired
    public SusersService(SuserDao susersMapper, BaseService baseService) {
        this.susersMapper = susersMapper;
        this.baseService = baseService;
    }


    /**
     * 创建用户
     * @param u
     * @return
     */
    public Map<String ,String> addUser(Suser u) throws NoSuchFieldException {
        Map<String , String> map = new HashMap<>(0);
        u.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        u.setCode(idService.getCode(Suser.class));
        try {
            baseService.save(u);
            map.put("message","成功");
        } catch (NotTableEntityException | ColumnIsNullException | IllegalAccessException e) {
            map.put("message", e.getMessage());
            e.printStackTrace();
        }
        return map;
    }

    public Map<String,String> updataUser(Suser suser){
        Map<String, String> map = new HashMap<>(0);
        try {
            baseService.updata(suser);
            map.put("message","修改成功");
        } catch (NotTableEntityException | ColumnIsNullException | IllegalAccessException e) {
            map.put("message", e.getMessage());
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 查找所有用户
     * @return
     */
    public List<Suser> findAllUsers() throws NoSuchFieldException, IllegalAccessException {
        String src = idService.getCode(Suser.class);
        System.out.println(src);
        return susersMapper.findAllUser();
    }
}
