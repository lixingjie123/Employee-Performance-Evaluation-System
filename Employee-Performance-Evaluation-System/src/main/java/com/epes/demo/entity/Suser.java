package com.epes.demo.entity;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * @author lixingjie
 * Date: 2018-01-05
 * Time: 15:39
 */

@Table(name = "suser")
public class Suser extends BaseEntity implements Serializable {

    private final static long serialVersionUID = -3401425764178455363L;
    public final static String CODE_TITLE = "UX";

    @Column(name = "loginname",type = MySqlTypeConstant.VARCHAR,isNull = false,isUnique = true)
    private String loginName;

    @Column(name = "uname",type = MySqlTypeConstant.VARCHAR,isNull = false)
    private String uname;

    @Column(name = "password", type = MySqlTypeConstant.VARCHAR,isNull = false)
    private String password;

    @Column(name = "sex", type = MySqlTypeConstant.CHAR,length = 2)
    private String sex;

    @Column(name = "age",type = MySqlTypeConstant.INT, length = 2)
    private Integer age;

    @Column(name = "phone", type = MySqlTypeConstant.VARCHAR)
    private String phone;

    @Column(name = "address",type = MySqlTypeConstant.VARCHAR)
    private String address;

    @Column(name = "role",type = MySqlTypeConstant.INT,isNull = false,length = 1)
    private Integer role;

    @Column(name = "deptid", type = MySqlTypeConstant.VARCHAR)
    private String deptid;

    @Column(name = "id", type = MySqlTypeConstant.VARCHAR, isKey = true)
    private String id;

    @Column(name = "createtime", type = MySqlTypeConstant.DATETIME)
    private Date createtime;

    @Column(name = "modifiedtime", type = MySqlTypeConstant.DATETIME)
    private Date modifiedtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "Suser{" +
                "loginName='" + loginName + '\'' +
                ", uname='" + uname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", role=" + role +
                ", deptid='" + deptid + '\'' +
                ", id='" + id + '\'' +
                ", createtime=" + createtime +
                ", modifiedtime=" + modifiedtime +
                '}';
    }
}
