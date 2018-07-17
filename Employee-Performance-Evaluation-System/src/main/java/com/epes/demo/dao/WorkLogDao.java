package com.epes.demo.dao;

import com.epes.demo.entity.WorkLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;


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

    @Select("select * from demo_worklog where userid = #{userid} ")
    List<WorkLog> findLogByUserid(String userid);

    @Select("SELECT\n" +
            "demo_worklog.id AS id,\n" +
            "demo_worklog.content AS content,\n" +
            "demo_worklog.dr AS dr,\n" +
            "demo_worklog.pojid AS pojid,\n" +
            "demo_worklog.workdate AS workdate,\n" +
            "demo_project.`name` AS pojname\n" +
            "FROM\n" +
            "demo_worklog\n" +
            "INNER JOIN demo_project ON demo_worklog.pojid = demo_project.id\n" +
            "WHERE\n" +
            "demo_worklog.userid = #{userid} and\n" +
            "demo_worklog.workdate BETWEEN  #{startdate} and #{enddate} and\n" +
            "demo_worklog.pojid like '%${pojid}%' order by workdate desc")
    List<WorkLog> findLogByUserId(@Param("userid") String userid, @Param("pojid") String pojid,
                                  @Param("startdate") String startdate, @Param("enddate") String enddate);

}
