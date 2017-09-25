/**
 * 
 */
package com.d2l2c.user.management.service;

import com.d2l2c.user.management.bean.User;

/**
 * @author dayanlazare
 *
 */
public interface UserService {

	public User validateUser(String username, String password) throws Exception;

	public void add(User user) throws Exception;

	public Iterable<User> findAll() throws Exception;

}
