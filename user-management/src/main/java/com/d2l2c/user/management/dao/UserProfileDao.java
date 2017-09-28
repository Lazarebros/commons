package com.d2l2c.user.management.dao;

import java.util.List;

import com.d2l2c.user.management.bean.UserProfile;

public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(Long id);

}
