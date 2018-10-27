/**
 * 
 */
package com.d2l2c.user.management.sping.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.d2l2c.user.management.bean.User;

/**
 * @author dayanlazare
 *
 */
@Configuration
@Import(value={UserSecurityConfiguration.class})
@PropertySource(value = "classpath:user-db-test.properties", ignoreResourceNotFound = true)
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "userEntityManager", transactionManagerRef = "userTransactionManager")
@ComponentScans(value = { @ComponentScan("com.d2l2c.user.management") })
public class UserJPAConfig {

	@Autowired
	private Environment environment;

	@Bean
	public LocalContainerEntityManagerFactoryBean userEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setPackagesToScan(User.class.getPackage().getName());
		em.setPersistenceUnitName("userPersistenceUnit");
		em.setDataSource(userDataSource());

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.batch.size", environment.getRequiredProperty("hibernate.batch.size"));
		em.setJpaPropertyMap(properties);

		return em;
	}

	@Bean
	public DataSource userDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("user.db.driver"));
		dataSource.setUrl(environment.getRequiredProperty("user.db.url"));
		dataSource.setUsername(environment.getRequiredProperty("user.db.username"));
		dataSource.setPassword(environment.getRequiredProperty("user.db.password"));
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager userTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(userEntityManager().getObject());
		return transactionManager;
	}

}
