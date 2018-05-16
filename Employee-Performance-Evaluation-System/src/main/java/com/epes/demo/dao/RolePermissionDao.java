package com.epes.demo.dao;

import com.epes.demo.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * Description:
 * Date: 2018/4/18
 * Time: 11:24
 *
 * @Author lixingjie
 * @Modifice
 */

@Mapper
public interface RolePermissionDao {

    @Select("select * from demo_role_permission where role_id = #{roleId}")
    List<RolePermission> findRolePerByRid(@Param("roleId")String roleId);
}
