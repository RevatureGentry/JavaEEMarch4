package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionFactory {

	private static final Properties props = getJdbcProperties();
	
	public static final String USERS_DDL = "CREATE TABLE users (id IDENTITY PRIMARY KEY, username VARCHAR(255), password VARCHAR(255), role VARCHAR(255))";
	public static final String TODOS_DDL = "CREATE TABLE todos (id IDENTITY PRIMARY KEY, title VARCHAR(255), description VARCHAR(255), username VARCHAR(255))";
	public static final String INSERT_USER_QUERY = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
	public static final String INSERT_TODO_QUERY = "INSERT INTO todos (title, description, username) VALUES (?, ?, ?)";
	
	// Private Constructor to restrict instantiation
	private ConnectionFactory() {}
	
	
	public static void initializeDatabase() {
		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection(props.getProperty("jdbc.url"), 
														  props.getProperty("jdbc.username"), 
														  props.getProperty("jdbc.password"));
			Statement s = conn.createStatement();
			
			if (!s.execute(USERS_DDL))
				System.out.println("Users table created!");
			if (!s.execute(TODOS_DDL))
				System.out.println("Todos table created!");
			
			
			PreparedStatement stmt = conn.prepareStatement(INSERT_USER_QUERY);
			stmt.setString(1, "william");
			stmt.setString(2, "Password123!");
			stmt.setString(3, "employee");
			if (stmt.executeUpdate() == 1) {
				System.out.println("User persisted successfully!!");
			}
			
			stmt = conn.prepareStatement(INSERT_USER_QUERY);
			stmt.setString(1, "manager");
			stmt.setString(2, "Password123!");
			stmt.setString(3, "manager");
			if (stmt.executeUpdate() == 1) 
				System.out.println("User persisted successfully!!");
			
			
			stmt = conn.prepareStatement(INSERT_TODO_QUERY);
			stmt.setString(1, "Test Title");
			stmt.setString(2, "Test Description");
			stmt.setString(3, "william");
			if (stmt.executeUpdate() == 1)
				System.out.println("Todo persisted successfully!");
			
			stmt = conn.prepareStatement(INSERT_TODO_QUERY);
			stmt.setString(1, "Test Title");
			stmt.setString(2, "Test Description");
			stmt.setString(3, "william");
			if (stmt.executeUpdate() == 1)
				System.out.println("Todo persisted successfully!");
			
			stmt = conn.prepareStatement(INSERT_TODO_QUERY);
			stmt.setString(1, "Test Title");
			stmt.setString(2, "Test Description");
			stmt.setString(3, "william");
			if (stmt.executeUpdate() == 1)
				System.out.println("Todo persisted successfully!");
			
			stmt = conn.prepareStatement(INSERT_TODO_QUERY);
			stmt.setString(1, "Test Title");
			stmt.setString(2, "Test Description");
			stmt.setString(3, "william");
			if (stmt.executeUpdate() == 1)
				System.out.println("Todo persisted successfully!");
			
			stmt = conn.prepareStatement(INSERT_TODO_QUERY);
			stmt.setString(1, "Test Title");
			stmt.setString(2, "Test Description");
			stmt.setString(3, "william");
			if (stmt.executeUpdate() == 1)
				System.out.println("Todo persisted successfully!");

			stmt = conn.prepareStatement(INSERT_TODO_QUERY);
			stmt.setString(1, "Test Title");
			stmt.setString(2, "Test Description");
			stmt.setString(3, "manager");
			if (stmt.executeUpdate() == 1)
				System.out.println("Todo persisted successfully!");
			
			stmt = conn.prepareStatement(INSERT_TODO_QUERY);
			stmt.setString(1, "Test Title");
			stmt.setString(2, "Test Description");
			stmt.setString(3, "manager");
			if (stmt.executeUpdate() == 1)
				System.out.println("Todo persisted successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public static Connection getConnection() {
		try {
			Class.forName("org.h2.Driver");
			return DriverManager.getConnection(props.getProperty("jdbc.url"), 
															  props.getProperty("jdbc.username"), 
															  props.getProperty("jdbc.password"));
		} catch (SQLException e) {
			System.err.println("Error Code: " + e.getErrorCode());
			System.err.println("SQL State: " + e.getSQLState());
			throw new RuntimeException("Failed to add connection to connection pool");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Failed to load H2 Driver");
		}
	}
	
	private static final Properties getJdbcProperties() {
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException e) {
			throw new RuntimeException("Failed to load application.properties");
		}
		return props;
	}
}
