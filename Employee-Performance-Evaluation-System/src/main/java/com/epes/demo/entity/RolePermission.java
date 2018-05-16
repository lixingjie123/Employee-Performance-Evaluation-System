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
 * Time: 10:26
 *
 * @Author lixingjie
 * @Modifice
 */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@Table(name = "demo_role_permission")
public class RolePermission extends BaseEntity{

    @Column(name = "app_id", type = MySqlTypeConstant.VARCHAR, isNull = false)
    private String app_id;

    @Column(name = "role_id", type = MySqlTypeConstant.VARCHAR, isNull = false)
    private String role_id;

    @Column(name = "createtime", type = MySqlTypeConstant.DATETIME)
    private String createtime;

    @Column(name = "modifiedtime", type = MySqlTypeConstant.DATETIME)
    private String modifiedtime;

    @Column(name = "dr",type = MySqlTypeConstant.INT)
    private Integer dr;

}
