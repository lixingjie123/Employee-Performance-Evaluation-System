package com.epes.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * Description:
 * Date: 2018/1/11
 * Time: 17:59
 *
 * @Author lixingjie
 * @Modifice
 */
public interface BaseDao {

    @Insert("insert into ${tableName}(${field}) values(${val})")
    int insert(@Param("tableName")String tableName, @Param("field")String field, @Param("val")String val);
}