/**
 * 
 */
package com.d2l2c.user.management.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.d2l2c.user.management.bean.User;
import com.d2l2c.user.management.service.UserService;

/**
 * @author dayanlazare
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/user-applicationContext.xml" })
public class UserTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserTest.class);
	
	@Autowired
	private UserService userService;
	
	@Test
    public void listUsersTest() {
		try {
			List<User> users = userService.listUsers();
			assertThat(users.isEmpty(), is(false));
			for (User user : users) {
				LOGGER.info(user.toString());
			}
		} catch (Exception e) {
			fail();
		}
    }

}
