package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Todo;
import com.revature.util.ConnectionFactory;

public class TodoDaoImpl implements TodoDao {

	@Override
	public List<Todo> getAllTodos() {
		List<Todo> todos = new ArrayList<>();
		// Get our connection
		try (Connection conn = ConnectionFactory.getConnection()) {
			// Create our statement to communicate with the database
			Statement stmt = conn.createStatement();
			
			// Execute the statement, all matched records can be found in the ResultSet
			ResultSet rs = stmt.executeQuery("SELECT * FROM todos");
			
			// Populate our list of todos from the ResultSet
			while (rs.next()) {
				todos.add(new Todo(rs.getInt("id"), rs.getString("title"), rs.getString("description")));
			}
			
			// Return our Todos so that the application can further manipulate
			return todos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Todo getTodoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Todo createTodo(Todo todo) {
		// Get a connection to our Data Source
		try (Connection conn = ConnectionFactory.getConnection()) {
			// Initialize our Insert statement
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO todos (id, title, description) VALUES (?, ?, ?)");
			
			// Set the values of our Insert Statement to help prevent SQL Injection
			stmt.setInt(1, todo.getId());
			stmt.setString(2, todo.getTitle());
			stmt.setString(3, todo.getDescription());
			
			// Execute the query, determining the number of rows that were affected
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected == 1)
				return todo;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Todo();
	}

	@Override
	public Todo updateTodo(Todo toBeUpdated) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long deleteTodo(Todo... toBeDeleted) {
		// TODO Auto-generated method stub
		return 0;
	}

}
