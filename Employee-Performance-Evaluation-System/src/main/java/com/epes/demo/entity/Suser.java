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
    private String code;

    @Column(name = "uname",type = MySqlTypeConstant.VARCHAR,isNull = false)
    private String name;

    @Column(name = "age",type = MySqlTypeConstant.INT)
    private Integer age;

    @Column(name = "addss",type = MySqlTypeConstant.VARCHAR)
    private String add;

    @Column(name = "role",type = MySqlTypeConstant.INT,isNull = false,length = 1)
    private Integer role;

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return "Suser{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", add='" + add + '\'' +
                ", role=" + role +
                '}';
    }
}
