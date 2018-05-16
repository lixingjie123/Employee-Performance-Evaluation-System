package com.epes.demo.dao;

import com.epes.demo.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Description:
 * Date: 2018/4/18
 * Time: 9:37
 *
 * @Author lixingjie
 * @Modifice
 */

@Mapper
public interface RoleDao {
    @Select("select * from demo_role where id = #{id}")
    Role findRole(String id);
}
