/**
 * 
 */
package com.d2l2c.user.mangement.service;

import java.util.List;

import com.d2l2c.user.mangement.bean.User;

/**
 * @author dayanlazare
 *
 */
public interface UserService {

	public User validateUser(String username, String password) throws Exception;

	public void add(User user) throws Exception;

	public List<User> listUsers() throws Exception;

}
