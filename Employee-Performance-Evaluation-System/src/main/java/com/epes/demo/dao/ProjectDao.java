package com.epes.demo.dao;

import com.epes.demo.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Description:
 * Date: 2018/4/17
 * Time: 11:18
 *
 * @Author lixingjie
 * @Modifice
 */

@Mapper
public interface ProjectDao {

    @Update("update demo_project set deptid = #{deptid} where id = #{id}")
    void UpdateDept(@Param("deptid")String deptid, @Param("id")String id);

    @Select("select * from demo_project where id = #{id}")
    Project findPro(String id);
}
