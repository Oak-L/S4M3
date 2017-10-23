package com.oracle.dao;

import com.oracle.po.User;

public interface UserDao {
	public User findUserById(int id) throws Exception;
}
