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
	public List<Todo> getAllTodosByUsername(String username) {
		final List<Todo> todos = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM todos WHERE username = ?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				todos.add(new Todo(rs.getInt("id"), rs.getString("title"), rs.getString("description")));
			}
			return todos;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		// Return empty list upon failure
		return new ArrayList<>();
	}

	@Override
	public List<Todo> getAllTodos() {
		final List<Todo> todos = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM todos");
			while (rs.next()) {
				todos.add(new Todo(rs.getInt("id"), rs.getString("title"), rs.getString("description")));
			}
			return todos;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		// Return empty list upon failure
		return new ArrayList<>();
	}

	@Override
	public Todo createTodo(Todo todo, String username) {
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO todos (title, description, username) VALUES (?, ?, ?)");
			stmt.setString(1, todo.getTitle());
			stmt.setString(2, todo.getDescription());
			stmt.setString(3, username);
			if (stmt.executeUpdate() == 1) {
				return todo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		// Return empty Todo object upon failure
		return new Todo();
	}

}
