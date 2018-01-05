package com.epes.demo.mapper;

import com.epes.demo.entity.Susers;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: lixingjie
 * Date: 2017-12-25
 * Time: 17:10
 */
public interface SusersMapper {

    @Select("select * from susers")
    List<Susers> findAll();
}
