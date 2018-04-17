package com.epes.demo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * Description:
 * Date: 2018/4/17
 * Time: 9:56
 *
 * @Author lixingjie
 * @Modifice
 * 用户角色表
 */

@Getter
@Setter
@Table(name = "demo_user_role")
public class UserRole extends BaseEntity {

    @Column(name = "userid",type = MySqlTypeConstant.VARCHAR, isNull = false)
    private String userid;

    @Column(name = "roleid", type = MySqlTypeConstant.VARCHAR, isNull = false)
    private String roleid;

    @Column(name = "createtime", type = MySqlTypeConstant.DATETIME)
    private Date createtime;

    @Column(name = "modifiedtime", type = MySqlTypeConstant.DATETIME)
    private Date modifiedtime;

    @Column(name = "dr",type = MySqlTypeConstant.INT)
    private Integer dr;

}
