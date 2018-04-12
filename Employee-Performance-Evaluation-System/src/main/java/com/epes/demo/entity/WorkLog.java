package com.epes.demo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.util.Date;

/**
 * Description:
 * Date: 2018/4/2
 * Time: 9:59
 *
 * @Author lixingjie
 * @Modifice
 */

@Table(name = "demo_worklog")
public class WorkLog extends BaseEntity{

    @Column(name = "id", type = MySqlTypeConstant.CHAR, isKey = true, length = 36)
    private String id;

    @Column(name = "startdate", type = MySqlTypeConstant.DATETIME)
    private Date startdate;

    @Column(name = "enddate", type = MySqlTypeConstant.DATETIME)
    private Date enddate;

    @Column(name = "content", type = MySqlTypeConstant.TEXT, isNull = false)
    private String content;

    @Column(name = "createtime", type = MySqlTypeConstant.DATETIME)
    private Date createtime;

    @Column(name = "modifiedtime", type = MySqlTypeConstant.DATETIME)
    private Date modifiedtime;

    @Column(name = "dr",type = MySqlTypeConstant.INT)
    private Integer dr;

    /**
     * 关联用户表
     */
    @Column(name = "userid", type = MySqlTypeConstant.CHAR, isNull = false)
    private String userId;

    private String userNmae;

    /**
     * 关联项目表
     */
    @Column(name = "pojid", type = MySqlTypeConstant.CHAR, isNull = false)
    private String pojId;

    private String pojName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNmae() {
        return userNmae;
    }

    public void setUserNmae(String userNmae) {
        this.userNmae = userNmae;
    }

    public String getPojId() {
        return pojId;
    }

    public void setPojId(String pojId) {
        this.pojId = pojId;
    }

    public String getPojName() {
        return pojName;
    }

    public void setPojName(String pojName) {
        this.pojName = pojName;
    }
}
