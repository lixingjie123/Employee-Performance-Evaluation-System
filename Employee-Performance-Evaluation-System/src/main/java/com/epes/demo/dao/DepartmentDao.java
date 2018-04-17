package com.epes.demo.dao;

import com.epes.demo.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

}
