package com.d2l2c.user.mangement.util;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.d2l2c.user.mangement.bean.User;
import com.d2l2c.user.mangement.service.UserService;
import com.d2l2c.user.mangement.spring.config.PersistenceJPAConfig;

public class SpringHibernateMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = null;
		try {
			context = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);

			UserService userService = context.getBean(UserService.class);

			// Get Users
			List<User> users = userService.listUsers();
			for (User user : users) {
				System.out.println("Id = " + user.getId());
				System.out.println("First Name = " + user.getUsername());
				System.out.println("Last Name = " + user.getPassword());
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (context != null) {
				context.close();
			}
		}
	}

}
