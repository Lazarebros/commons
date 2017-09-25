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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.h2.tools.RunScript;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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

	@Autowired
	private EntityManager em;

	@Before
	public void initializeDatabase() {
		Session session = em.unwrap(Session.class);
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				try {
					File script = new File(getClass().getResource("/create-db.sql").getFile());
					RunScript.execute(connection, new FileReader(script));

					script = new File(getClass().getResource("/insert-db.sql").getFile());
					RunScript.execute(connection, new FileReader(script));
				} catch (FileNotFoundException e) {
					throw new RuntimeException("could not initialize with script");
				}
			}
		});
	}

	@Transactional("userTransactionManager")
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

	@Transactional("userTransactionManager")
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
