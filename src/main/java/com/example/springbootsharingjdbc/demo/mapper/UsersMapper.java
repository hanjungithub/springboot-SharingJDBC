package com.example.springbootsharingjdbc.demo.mapper;


import com.example.springbootsharingjdbc.demo.model.Users;

import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    List<Users> selectByUserName(Users record);
}