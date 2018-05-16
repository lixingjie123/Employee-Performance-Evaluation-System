package com.epes.demo.dao;

import com.epes.demo.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * Description:
 * Date: 2018/4/22
 * Time: 15:28
 *
 * @Author lixingjie
 * @Modifice
 */

@Mapper
public interface UserRoleDao {
    @Select("select * from demo_user_role where userid = #{userId}")
    List<UserRole> findUserRole(@Param("userId") String userId);
}
