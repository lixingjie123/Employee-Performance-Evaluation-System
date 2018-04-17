package com.epes.demo.dao;

import com.epes.demo.entity.WorkLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


/**
 * Description:
 * Date: 2018/4/17
 * Time: 15:58
 *
 * @Author lixingjie
 * @Modifice
 */

@Mapper
public interface WorkLogDao {

    @Select("select * from demo_worklog where id = #{id}")
    WorkLog findLog(String id);
}
