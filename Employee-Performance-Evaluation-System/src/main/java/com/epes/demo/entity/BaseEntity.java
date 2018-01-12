package com.epes.demo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.util.Date;

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

    @Column(name = "gmt_create", type = MySqlTypeConstant.DATETIME)
    protected Date gmtCreate;

    @Column(name = "gmt_modified", type = MySqlTypeConstant.DATETIME)
    protected Date gmtModified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
