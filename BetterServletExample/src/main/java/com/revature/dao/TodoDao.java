package com.revature.dao;

import java.util.List;

import com.revature.model.Todo;

public interface TodoDao {

	List<Todo> getAllTodosByUsername(String username);
	List<Todo> getAllTodos();
	Todo createTodo(Todo todo, String username);
}
