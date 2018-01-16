package com.epes.demo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.sql.Date;


/**
 * Description:
 * Date: 2018/1/11
 * Time: 16:49
 *
 * @Author lixingjie
 * @Modifice
 */

public class BaseEntity {

    @Column(name = "id", type = MySqlTypeConstant.VARCHAR, isKey = true)
    protected String id;

    @Column(name = "createtime", type = MySqlTypeConstant.DATETIME)
    protected Date createtime;

    @Column(name = "modifiedtime", type = MySqlTypeConstant.DATETIME)
    protected Date modifiedtime;

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
}
