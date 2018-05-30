package com.aissue.service;


import com.aissue.entity.User;

/**
 * Created by linzhipeng on 2017/8/23.
 */
public interface UserService {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUser(String username, String password, String departmentCode);
}
