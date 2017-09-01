package com.d2l2c.user.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.d2l2c.user.management.bean.User;
import com.d2l2c.user.management.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional("userTransactionManager")
	@Override
	public User validateUser(String username, String password) throws Exception {
		return userDao.getUser(username, password);
	}

	@Transactional("userTransactionManager")
	@Override
	public void add(User user) throws Exception {
		userDao.add(user);
	}

	@Transactional("userTransactionManager")
	@Override
	public Iterable<User> findAll() throws Exception {
		return userDao.findAll();
	}

}
