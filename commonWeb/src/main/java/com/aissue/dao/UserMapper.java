package com.aissue.dao;


import com.aissue.entity.User;
import org.apache.ibatis.annotations.Param;

//@MyBatis
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUser(@Param("userName") String userName, @Param("password") String password, @Param("departmentCode") String departmentCode);
}