package com.epes.demo.dao;

import com.epes.demo.entity.BaseEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Description:
 * Date: 2018/1/11
 * Time: 17:59
 *
 * @Author lixingjie
 * @Modifice
 */
public interface BaseDao {

    /**
     * 公共接口：向数据库插入一条数据
     * @param tableName
     * @param field
     * @param val
     * @return
     */
    @Insert("insert into ${tableName}(${field}) values(${val})")
    int insert(@Param("tableName")String tableName, @Param("field")String field, @Param("val")String val);

    /**
     * 公共接口：通过 id 修改数据库数据
     * @param tableName
     * @param val
     * @param id
     * @return
     */
    @Update("update ${tableName} set ${val} where id = ${id}")
    int updata(@Param("tableName")String tableName, @Param("val")String val, @Param("id")String id);

    /**
     * 公共接口：通过 id 删除数据库数据
     * @param tableName
     * @param id
     * @return
     */
    @Delete("delete from ${tableName} where id = #{id}")
    int delete(@Param("tableName")String tableName, @Param("id")String id);

    /*
    @Select("select * from ${tableName}")
    <T extends BaseEntity> List<T> query(@Param("tableName")String tableName);
    */
}