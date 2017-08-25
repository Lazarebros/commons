package com.d2l2c.user.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.d2l2c.user.management.bean.User;
import com.d2l2c.user.management.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public User validateUser(String username, String password) throws Exception {
		return userDao.getUser(username, password);
	}

	@Transactional
	@Override
	public void add(User user) throws Exception {
		userDao.add(user);
	}

	@Transactional(readOnly = true)
	@Override
	public List<User> listUsers() throws Exception {
		return userDao.listUsers();
	}

}
