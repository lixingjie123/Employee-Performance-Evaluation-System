package com.epes.demo.dao;

import com.epes.demo.entity.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Date: 2018/3/19
 * Time: 17:32
 *
 * @Author lixingjie
 * @Modifice
 */

@Mapper
public interface UserLoginDao {

    @Update("update demo_user_login set password=#{password},modifiedtime=${modifiedtime} where id = #{id}")
    int updatePassword(UserLogin userLogin);

    @Select("select password from demo_user_login where  id= #{id}")
    String findUserId(String id);
}
