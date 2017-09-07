/**
 * 
 */
package com.d2l2c.user.management.test;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.d2l2c.user.management.bean.User;
import com.d2l2c.user.management.service.UserService;
import com.d2l2c.user.management.sping.config.UserJPAConfig;

/**
 * @author dayanlazare
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UserJPAConfig.class })
public class UserJPATest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserJPATest.class);

	@Autowired
	private UserService userService;

	@Test
	public void listUsersTest() {
		Iterable<User> users;
		try {
			users = userService.findAll();
			assertThat(users, is(not(Optional.empty())));
			users.forEach(user -> {
				try {
					assertNotNull(user.getPassword());
				} catch (Exception e) {
					LOGGER.error(e.getMessage());
					fail();
				}
			});
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			fail();
		}
	}

	@Test
	public void validateUserTest() {
		try {
			User user = userService.validateUser("test", "test1123");
			assertNull(user);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			fail();
		}
	}

}
