package com.revature.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.revature.properties.HibernateProperties;

@Configuration
@EnableJpaRepositories(basePackages = "com.revature.repository")
public class JpaConfig {

	@Autowired
	private HibernateProperties hibernateProperties;
	
	/*
	 * When we configure ORM (either JPA or Hibernate), we must supply the following 3 beans
	 * 		1. javax.sql.DataSource
	 * 		2. LocalSessionFactoryBean (Hibernate) or LocalContainerEntityManagerFactoryBean (JPA)
	 * 		3. HibernateTransactionManager or JpaTransactionManager
	 */
	
	// Session (Hibernate) is equivalent to EntityManager (JPA)
	// SessionFactory (Hibernate) is equivalent to EntityManagerFactory (JPA)
	
	
	@Bean
	public DataSource dataSource() {
		// Think of this as everything you need for JDBC
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(hibernateProperties.getUrl());
		dataSource.setUsername(hibernateProperties.getUsername());
		dataSource.setPassword(hibernateProperties.getPassword());
		dataSource.setDriverClassName(hibernateProperties.getDriverClassName());
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("com.revature.model");
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setGenerateDdl(true);
		adapter.setDatabase(Database.ORACLE);
		emf.setJpaVendorAdapter(adapter);
		
		return emf;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setDataSource(dataSource());
		manager.setEntityManagerFactory(entityManagerFactory().getObject());
		return manager;
	}
	
	
	// hibernate.url=jdbc:h2:mem:~/db
	// hibernate.username=sa
	// hibernate.password=
	// hibernate.driver-class-name=org.h2.Driver
	
	
	
	
	
	
	
	
}
