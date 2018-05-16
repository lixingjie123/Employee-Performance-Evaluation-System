package com.epes.demo.dao;

import com.epes.demo.entity.PerformanceScore;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Description:
 * Date: 2018/5/7
 * Time: 0:49
 *
 * @Author lixingjie
 * @Modifice
 */
@Mapper
public interface ScoreDao {

    @Select("SELECT\n" +
            "demo_performance_score.id AS id,\n" +
            "date(demo_performance_score.startdate) AS startdate,\n" +
            "date(demo_performance_score.enddate) AS enddate,\n" +
            "demo_performance_score.score AS score,\n" +
            "demo_performance_score.leaderid AS leaderid,\n" +
            "demo_performance_score.review AS review,\n" +
            "demo_user_info.`name` AS leaderName \n"+
            "FROM\n" +
            "demo_performance_score\n" +
            "INNER JOIN demo_user_info ON demo_performance_score.leaderid = demo_user_info.id\n" +
            "WHERE\n" +
            "demo_performance_score.empid = #{userid}\n" +
            "ORDER BY\n" +
            "demo_performance_score.createtime DESC")
    List<PerformanceScore> findScoreByEmpid(@Param("userid") String userid);
}
