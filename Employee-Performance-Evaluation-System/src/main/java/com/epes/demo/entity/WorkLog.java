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
 * Time: 9:59
 *
 * @Author lixingjie
 * @Modifice
 */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@Table(name = "demo_worklog")
public class WorkLog extends BaseEntity{

    @Column(name = "id", type = MySqlTypeConstant.CHAR, isKey = true, length = 36)
    private String id;

    @Column(name = "workdate", type = MySqlTypeConstant.DATETIME)
    private String workdate;

    @Column(name = "content", type = MySqlTypeConstant.TEXT, isNull = false)
    private String content;

    @Column(name = "createtime", type = MySqlTypeConstant.DATETIME)
    private String createtime;

    @Column(name = "modifiedtime", type = MySqlTypeConstant.DATETIME)
    private String modifiedtime;

    @Column(name = "dr",type = MySqlTypeConstant.INT)
    private Integer dr;

    /**
     * 关联用户表
     */
    @Column(name = "userid", type = MySqlTypeConstant.CHAR, isNull = false)
    private String userid;

    private String usernmae;

    /**
     * 关联项目表
     */
    @Column(name = "pojid", type = MySqlTypeConstant.CHAR, isNull = false)
    private String pojid;

    private String pojname;

}
