package com.epes.demo.dao;

import com.epes.demo.entity.Suser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 查找loginname是否唯一
     * @param loginname
     * @return
     */
    @Select("select loginname from suser where loginname = #{loginname}")
    String queryByLoginName(String loginname);

    @Select("select id, uname, loginname, sex, deptid, role, address, phone, age, createtime from suser where loginname = #{loginname} and password = #{password}")
    Suser login(@Param("loginname")String loginname, @Param("password")String password);

    @Select("Select * from suser where id = #{id}")
    Suser findById(@Param("id")String id);
}
