package com.oracle.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.oracle.po.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	@Override
	public User findUserById(int id) throws Exception {
		// 继承了SqlSessionDaoSupport,通过getSqlSession()得到sqlSession
		SqlSession sqlSession = this.getSqlSession();
		User user = sqlSession.selectOne("test.findUserById", id);
		return user;
	}
}
