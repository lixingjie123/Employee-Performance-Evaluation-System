package com.epes.demo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.sql.Date;

/**
 * Description:
 * Date: 2018/3/19
 * Time: 17:00
 *
 * @Author lixingjie
 * @Modifice
 */

@Table(name = "demo_user_login")
public class UserLogin extends BaseEntity{

    @Column(name = "id", type = MySqlTypeConstant.CHAR, length = 36, isKey = true, isNull = false)
    private String id;

    @Column(name = "loginname", type = MySqlTypeConstant.VARCHAR, length = 36,isNull = false)
    private String loginName;

    @Column(name = "password", type = MySqlTypeConstant.VARCHAR, isNull = false)
    private String password;

    @Column(name = "createtime", type = MySqlTypeConstant.DATETIME)
    private Date createtime;

    @Column(name = "modifiedtime", type = MySqlTypeConstant.DATETIME)
    private Date modifiedtime;

    @Column(name = "dr", type = MySqlTypeConstant.INT)
    private Integer dr;

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

}
