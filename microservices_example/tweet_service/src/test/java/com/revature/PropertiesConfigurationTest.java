package com.revature;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.properties.HibernateProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesConfigurationTest {

	@Autowired
	private HibernateProperties hibernateProperties;
	
	@Test
	public void url_ShouldBePulledFromConfigServer() {
		assertThat(hibernateProperties.getUrl()).isNotBlank();
	}
	
	@Test
	public void username_ShouldBePulledFromConfigServer() {
		assertThat(hibernateProperties.getUsername()).isNotBlank();
	}
	
	@Test
	public void password_ShouldBePulledFromConfigServer() {
		assertThat(hibernateProperties.getPassword()).isNotBlank();
	}
	
	@Test
	public void driverClassName_ShouldBePulledFromConfigServer() {
		assertThat(hibernateProperties.getDriverClassName()).isNotBlank();
	}
	
	@Test
	public void dialect_ShouldBePulledFromConfigServer() {
		assertThat(hibernateProperties.getDialect()).isNotBlank();
	}
	
	@Test
	public void hbm2ddl_ShouldBePulledFromConfigServer() {
		assertThat(hibernateProperties.getHbm2ddl()).isNotBlank();
	}
	
	
}
