package com.epes.demo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


/**
 * Description:
 * Date: 2018/4/2
 * Time: 9:52
 *
 * @Author lixingjie
 * @Modifice
 */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@Table(name = "demo_project")
public class Project extends BaseEntity {

    @Column(name = "id", type = MySqlTypeConstant.CHAR, isKey = true, length = 36)
    private String id;

    @Column(name = "name", type = MySqlTypeConstant.VARCHAR,isNull = false)
    private String name;

    @Column(name = "code", type = MySqlTypeConstant.VARCHAR)
    private String code;

    @Column(name = "startdate", type = MySqlTypeConstant.DATETIME)
    private String startdate;

    @Column(name = "enddate", type = MySqlTypeConstant.DATETIME)
    private String enddate;

    @Column(name = "deptid", type = MySqlTypeConstant.VARCHAR)
    private String deptid;

    private String deptname;

    @Column(name = "createtime", type = MySqlTypeConstant.DATETIME)
    private String createtime;

    @Column(name = "modifiedtime", type = MySqlTypeConstant.DATETIME)
    private String modifiedtime;

    @Column(name = "dr",type = MySqlTypeConstant.INT)
    private Integer dr;

}
