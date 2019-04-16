package com.revature.applicationcontext.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionFactory {

	private static final Properties props = getJdbcProperties();
	public static final String TODOS_DDL = "CREATE TABLE todos(id IDENTITY PRIMARY KEY, title VARCHAR(255), description VARCHAR(255))";
	public static final String INSERT_TODO_QUERY = "INSERT INTO todos (id, title, description) VALUES (?, ?, ?)";
	
	public static Connection getConnection() {
		try {
			Class.forName("org.h2.Driver");
			return DriverManager.getConnection(props.getProperty("jdbc.url"), 
											   props.getProperty("jdbc.username"), 
											   props.getProperty("jdbc.password"));
		} catch (SQLException e) {
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
			throw new RuntimeException("Failed to get JDBC Connection");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Failed to locate H2 Database Driver");
		}
	}
	
	/*
	 * ONLY NEEDED FOR OUR H2 EXAMPLE!!!
	 */
	public static void initializeDatabase() {
		// Create our todos table
		Connection conn = getConnection();
		try {
			Statement createTodoTable = conn.createStatement();
			if (!createTodoTable.execute(TODOS_DDL))
				System.out.println("Todos table created!");
			PreparedStatement insertTodoStatement = conn.prepareStatement(INSERT_TODO_QUERY);
			insertTodoStatement.setInt(1, 1);
			insertTodoStatement.setString(2, "Test Title");
			insertTodoStatement.setString(3, "Test Description");
			if (insertTodoStatement.executeUpdate() == 1) {
				System.out.println("Todo inserted successfully!");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static Properties getJdbcProperties() {
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException e) {
			throw new RuntimeException("Failed to locate application.properties");
		}
		return props;
	}
}
