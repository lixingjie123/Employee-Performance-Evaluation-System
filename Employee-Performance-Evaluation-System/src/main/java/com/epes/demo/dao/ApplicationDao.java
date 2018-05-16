package com.epes.demo.dao;

import com.epes.demo.entity.Application;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.*;
/**
 * Description:
 * Date: 2018/5/4
 * Time: 10:35
 *
 * @Author lixingjie
 * @Modifice
 */
@Mapper
public interface ApplicationDao {

    @Select("select * from demo_application where id = #{id} order by createtime")
    Application findAppById(String id);
}
