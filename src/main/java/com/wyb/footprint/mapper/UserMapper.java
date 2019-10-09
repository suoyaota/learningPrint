package com.wyb.footprint.mapper;

import com.wyb.footprint.entity.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 */
@Component
public interface UserMapper {
    @Select("select name from user where userId=#{userId}")
    String getNameByUserId(@Param("userId")long id);
    @Select("select userId from user where userName = #{userName}")
    Long getUserIdByUserName(@Param("userName")String userName);
    @Insert("insert into user ( userName, password) values( #{userName}, #{password})")
    void signUp(UserDO userDO);
    @Select("select password from user where userName=#{userName}")
    String getPasswordByUserName(@Param("userName") String userName);
}
