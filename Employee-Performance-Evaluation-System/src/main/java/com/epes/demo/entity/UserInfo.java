package com.epes.demo.entity;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * @author lixingjie
 * Date: 2018-01-05
 * Time: 15:39
 */

@Getter
@Setter
@Table(name = "demo_user_info")
public class UserInfo extends BaseEntity implements Serializable {
    public final static String CODE_TITLE = "UX";

    @Column(name = "id", type = MySqlTypeConstant.CHAR, isKey = true, length = 36)
    private String id;

    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,isNull = false)
    private String name;

    @Column(name = "loginname", type = MySqlTypeConstant.VARCHAR, length = 36,isNull = false)
    private String loginName;

    @Column(name = "sex", type = MySqlTypeConstant.CHAR,length = 2)
    private String sex;

    @Column(name = "age",type = MySqlTypeConstant.INT, length = 2)
    private Integer age;

    @Column(name = "phone", type = MySqlTypeConstant.VARCHAR)
    private String phone;

    @Column(name = "address",type = MySqlTypeConstant.VARCHAR)
    private String address;

    /**
     * 关联部门表
     */
    @Column(name = "deptid", type = MySqlTypeConstant.VARCHAR)
    private String deptid;

    /**
     * 用于展示部门名称
     */
    private String deptName;

    @Column(name = "createtime", type = MySqlTypeConstant.DATETIME)
    private Date createtime;

    @Column(name = "modifiedtime", type = MySqlTypeConstant.DATETIME)
    private Date modifiedtime;

    @Column(name = "dr",type = MySqlTypeConstant.INT)
    private Integer dr;

}
