/**
 * 
 */
package com.d2l2c.user.mangement.dao;

import java.util.List;

import com.d2l2c.user.mangement.bean.User;

/**
 * @author dayanlazare
 *
 */
public interface UserDao {

	public User getUser(String username, String password) throws Exception;

	public void add(User user) throws Exception;

	public List<User> listUsers() throws Exception;

}
