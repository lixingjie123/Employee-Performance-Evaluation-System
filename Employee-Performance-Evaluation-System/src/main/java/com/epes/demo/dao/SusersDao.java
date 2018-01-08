package com.epes.demo.dao;

import com.epes.demo.entity.Susers;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: lixingjie
 * Date: 2017-12-25
 * Time: 17:10
 */

public interface SusersDao {

    @Select("select * from susers")
    List<Susers> findAll();

    @Insert("insert into susers value (#{id},#{code},#{name},#{age},#{add},#{role})")
    int insertUser(Susers susers);
}
