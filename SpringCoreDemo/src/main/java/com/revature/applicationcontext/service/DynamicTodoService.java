package com.revature.applicationcontext.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.applicationcontext.model.Todo;

@Component
public class DynamicTodoService implements TodoService {
	
	public DynamicTodoService() {
		ConnectionFactory.initializeDatabase();
	}

	@Override
	public List<Todo> getAllTodos() {
		List<Todo> todos = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM todos");
			while (rs.next()) {
				todos.add(new Todo(rs.getInt("id"), rs.getString("title"), rs.getString("description")));
			}
			return todos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
