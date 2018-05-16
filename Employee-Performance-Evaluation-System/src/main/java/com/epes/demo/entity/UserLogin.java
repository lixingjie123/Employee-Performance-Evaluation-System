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
 * Date: 2018/3/19
 * Time: 17:00
 *
 * @Author lixingjie
 * @Modifice
 */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@Table(name = "demo_user_login")
public class UserLogin extends BaseEntity{

    @Column(name = "id", type = MySqlTypeConstant.CHAR, length = 36, isKey = true, isNull = false)
    private String id;

    @Column(name = "password", type = MySqlTypeConstant.VARCHAR, isNull = false)
    private String password;

    @Column(name = "createtime", type = MySqlTypeConstant.DATETIME)
    private String createtime;

    @Column(name = "modifiedtime", type = MySqlTypeConstant.DATETIME)
    private String modifiedtime;

    @Column(name = "dr", type = MySqlTypeConstant.INT)
    private Integer dr;

}
