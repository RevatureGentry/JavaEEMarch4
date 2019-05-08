package com.revature.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
/*
 * @ConfigurationProperties reads a properties file, and assigns any value that
 * matches the fields in this class that begin with hibernate
 */
@ConfigurationProperties(prefix = "hibernate")
public class HibernateProperties {

	// If there a property available that is hibernate.url, that value is assigned
	// here
	private String url;

	private String username;

	private String password;

	private String driverClassName;

	private String dialect;

	private String hbm2ddl;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getDialect() {
		return dialect;
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

	public String getHbm2ddl() {
		return hbm2ddl;
	}

	public void setHbm2ddl(String hbm2ddl) {
		this.hbm2ddl = hbm2ddl;
	}

}
