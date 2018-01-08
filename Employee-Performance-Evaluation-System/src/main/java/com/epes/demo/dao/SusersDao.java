package com.epes.demo.dao;

import com.epes.demo.entity.Susers;
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

public interface SusersDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from susers")
    List<Susers> findAll();

    /**
     * 新增一个用户
     * @param susers
     * @return
     */
    @Insert("insert into susers value (#{id},#{code},#{name},#{age},#{add},#{role})")
    int insertUser(Susers susers);
}
