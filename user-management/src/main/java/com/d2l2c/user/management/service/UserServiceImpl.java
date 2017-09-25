package com.d2l2c.user.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.d2l2c.common.util.password.PasswordUtil;
import com.d2l2c.user.management.bean.User;
import com.d2l2c.user.management.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional("userTransactionManager")
	@Override
	public User validateUser(String username, String password) throws Exception {
		User user = userDao.getUser(username);
		if(user == null || !PasswordUtil.check(password, user.getPassword())) {
			user = null;
		}
		return user;
	}

	@Transactional("userTransactionManager")
	@Override
	public void add(User user) throws Exception {
		String encriptedPassword = PasswordUtil.getSaltedHash(user.getPassword());
		user.setPassword(encriptedPassword);
		userDao.add(user);
	}

	@Transactional("userTransactionManager")
	@Override
	public Iterable<User> findAll() throws Exception {
		return userDao.findAll();
	}

}
