package com.d2l2c.user.management.service;

import java.util.List;

import com.d2l2c.user.management.bean.UserProfile;


public interface UserProfileService {

	UserProfile findById(Long id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
