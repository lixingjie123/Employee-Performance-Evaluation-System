package com.epes.demo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Getter;
import lombok.Setter;

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
@Table(name = "demo_worklog")
public class WorkLog extends BaseEntity{

    @Column(name = "id", type = MySqlTypeConstant.CHAR, isKey = true, length = 36)
    private String id;

    @Column(name = "startdate", type = MySqlTypeConstant.DATETIME)
    private Date startdate;

    @Column(name = "enddate", type = MySqlTypeConstant.DATETIME)
    private Date enddate;

    @Column(name = "content", type = MySqlTypeConstant.TEXT, isNull = false)
    private String content;

    @Column(name = "createtime", type = MySqlTypeConstant.DATETIME)
    private Date createtime;

    @Column(name = "modifiedtime", type = MySqlTypeConstant.DATETIME)
    private Date modifiedtime;

    @Column(name = "dr",type = MySqlTypeConstant.INT)
    private Integer dr;

    /**
     * 关联用户表
     */
    @Column(name = "userid", type = MySqlTypeConstant.CHAR, isNull = false)
    private String userId;

    private String userNmae;

    /**
     * 关联项目表
     */
    @Column(name = "pojid", type = MySqlTypeConstant.CHAR, isNull = false)
    private String pojId;

    private String pojName;

}
