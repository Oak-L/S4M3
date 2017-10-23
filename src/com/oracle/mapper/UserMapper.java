package com.oracle.mapper;

import com.oracle.po.User;

//namespace与mapper接口地址相同
public interface UserMapper {
	public User findUserById(int id) throws Exception;
}
