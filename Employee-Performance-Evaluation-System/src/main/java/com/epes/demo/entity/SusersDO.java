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

@Table(name = "susers")
public class SusersDO {


    @Column(name = "id",type = MySqlTypeConstant.VARCHAR,length = 32,isKey = true,isNull = false)
    private String id;

    @Column(name = "code",type = MySqlTypeConstant.VARCHAR,isNull = false)
    private String code;

    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,isNull = false)
    private String name;

    @Column(name = "age",type = MySqlTypeConstant.INT)
    private Integer age;

    @Column(name = "add",type = MySqlTypeConstant.VARCHAR)
    private String add;

    @Column(name = "role",type = MySqlTypeConstant.INT,isNull = false,length = 1)
    private Integer role;

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
