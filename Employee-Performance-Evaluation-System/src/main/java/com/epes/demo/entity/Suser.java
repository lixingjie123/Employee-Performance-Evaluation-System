package com.epes.demo.entity;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * @author lixingjie
 * Date: 2018-01-05
 * Time: 15:39
 */

@Table(name = "suser")
public class Suser extends BaseEntity {

    public final static String CODE_TITLE = "UX";

    @Column(name = "codes",type = MySqlTypeConstant.VARCHAR,isNull = false,isUnique = true)
    private String codes;

    @Column(name = "uname",type = MySqlTypeConstant.VARCHAR,isNull = false)
    private String uname;

    @Column(name = "age",type = MySqlTypeConstant.INT)
    private Integer age;

    @Column(name = "addss",type = MySqlTypeConstant.VARCHAR)
    private String addss;

    @Column(name = "role",type = MySqlTypeConstant.INT,isNull = false,length = 1)
    private Integer role;

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

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAddss() {
        return addss;
    }

    public void setAddss(String addss) {
        this.addss = addss;
    }

    @Override
    public String toString() {
        return "Suser{" +
                "codes='" + codes + '\'' +
                ", uname='" + uname + '\'' +
                ", age=" + age +
                ", addss='" + addss + '\'' +
                ", role=" + role +
                ", id='" + id + '\'' +
                ", createtime=" + createtime +
                ", modifiedtime=" + modifiedtime +
                '}';
    }
}
