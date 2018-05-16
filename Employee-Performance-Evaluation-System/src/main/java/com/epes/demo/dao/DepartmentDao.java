package com.epes.demo.dao;

import com.epes.demo.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description:
 * Date: 2018/4/17
 * Time: 9:43
 *
 * @Author lixingjie
 * @Modifice
 */

@Mapper
public interface DepartmentDao {

    @Select("select * from demo_department where id = #{id}")
    Department findDept(String id);

    @Select("select * from demo_department ")
    List<Department> findAllDept();

    @Select("select d.id,d.name,d.code,d.createtime,d.modifiedtime,u.id,u.name,u.phone,u.code " +
            "from demo_department d" +
            "left join demo_user_info u " +
            "on d.userid = u.id")
    List<Department> findAllDeptList();



}
