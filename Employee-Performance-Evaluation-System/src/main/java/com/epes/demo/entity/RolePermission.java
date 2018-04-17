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
 * Time: 10:26
 *
 * @Author lixingjie
 * @Modifice
 */

@Getter
@Setter
@Table(name = "demo_role_permission")
public class RolePermission extends BaseEntity{

    @Column(name = "app_id", type = MySqlTypeConstant.VARCHAR, isNull = false)
    private String appId;

    @Column(name = "role_id", type = MySqlTypeConstant.VARCHAR, isNull = false)
    private String roleId;

    @Column(name = "createtime", type = MySqlTypeConstant.DATETIME)
    private Date createtime;

    @Column(name = "modifiedtime", type = MySqlTypeConstant.DATETIME)
    private Date modifiedtime;

    @Column(name = "dr",type = MySqlTypeConstant.INT)
    private Integer dr;

}
