/**
 * 
 */
package com.d2l2c.user.management.dao;

import java.util.List;

import com.d2l2c.user.management.bean.User;

/**
 * @author dayanlazare
 *
 */
public interface UserDao {

	public User findById(Long id);

	public User findByUsername(String username);

	public void save(User user);

	public void update(User user);

	public void delete(User user);
	
	public List<User> findAll();

}
