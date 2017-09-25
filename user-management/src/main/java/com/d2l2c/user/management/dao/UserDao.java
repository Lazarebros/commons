/**
 * 
 */
package com.d2l2c.user.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.d2l2c.user.management.bean.User;

/**
 * @author dayanlazare
 *
 */
public interface UserDao extends JpaRepository<User, Integer> {

	public User getUser(String username) throws Exception;

	public void add(User user) throws Exception;

}
