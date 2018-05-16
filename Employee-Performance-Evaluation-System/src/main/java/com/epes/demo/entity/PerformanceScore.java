package com.epes.demo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Description:
 * Date: 2018/5/2
 * Time: 10:21
 *
 * @Author lixingjie
 * @Modifice
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@Table(name = "demo_performance_score")
public class PerformanceScore extends BaseEntity{

    @Column(name = "id", type = MySqlTypeConstant.CHAR, isKey = true, length = 36)
    private String id ;

    @Column(name = "startdate", type = MySqlTypeConstant.DATETIME)
    private String startdate;

    @Column(name = "enddate", type = MySqlTypeConstant.DATETIME)
    private String enddate;

    @Column(name = "score", type = MySqlTypeConstant.INT,isNull = false)
    private String score;

    @Column(name = "review", type = MySqlTypeConstant.VARCHAR)
    private String review;


    @Column(name = "createtime", type = MySqlTypeConstant.DATETIME)
    private String createtime;

    @Column(name = "modifiedtime", type = MySqlTypeConstant.DATETIME)
    private String modifiedtime;

    @Column(name = "dr",type = MySqlTypeConstant.INT)
    private Integer dr;

    /**
     * 关联被评人
     */
    @Column(name = "empid", type = MySqlTypeConstant.VARCHAR)
    private String empid;

    private String empName;

    /**
     * 关联评分人
     */
    @Column(name = "leaderid", type = MySqlTypeConstant.VARCHAR)
    private String leaderid;

    private String leaderName;
}
