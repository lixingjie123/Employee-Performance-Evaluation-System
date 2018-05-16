package com.epes.demo.dao;

import com.epes.demo.entity.BaseEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * Date: 2018/1/11
 * Time: 17:59
 *
 * @Author lixingjie
 * @Modifice
 */

@Mapper
public interface BaseDao {

    /**
     * 公共接口：向数据库插入一条数据
     * @param tableName
     * @param field
     * @param val
     * @return
     */
    @Insert(value = "insert into ${tableName}(${field}) values(${val})")
    int insert(@Param("tableName")String tableName, @Param("field")String field, @Param("val")String val);

    /**
     * 公共接口：通过 id 修改数据库数据
     * @param tableName
     * @param val
     * @param id
     * @return
     */
    @Update(value = "update ${tableName} set ${val} where id = ${id}")
    int update(@Param("tableName")String tableName, @Param("val")String val, @Param("id")String id);

    /**
     * 公共接口：通过 id 删除数据库数据
     * @param tableName
     * @param id
     * @return
     */
    @Delete(value = "delete from ${tableName} where id = #{id}")
    int delete(@Param("tableName")String tableName, @Param("id")String id);

    /**
     * 公共接口：分页条件查询
     * @param tableName
     * @param search
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Select(value = "select * from ${tableName} ${search} limit #{pageIndex},#{pageSize}")
    List<Map<String, Object>> pageFind(@Param("tableName") String tableName,
                                       @Param("search")String search,
                                       @Param("pageIndex")int pageIndex,
                                       @Param("pageSize")int pageSize);
}