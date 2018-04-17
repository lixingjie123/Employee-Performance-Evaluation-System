package com.epes.demo.dao;

import com.epes.demo.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * @author lixingjie
 * Date: 2018-01-05
 * Time: 15:39
 */

@Mapper
public interface UserInfoDao {

    @Update("update demo_user_info set deptid = #{deptid} where id = #{id}")
    void UpdateDept(@Param("deptid")String deptid, @Param("id")String id);

    @Select("select * from demo_user_info where id = #{id}")
    UserInfo findUser(String id);
}
