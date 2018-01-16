package com.epes.demo.dao;

import com.epes.demo.entity.Suser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * @author lixingjie
 * Date: 2018-01-05
 * Time: 15:39
 */

public interface SuserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from suser")
    List<Suser> findAllUser();

}
