package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.annotations.Benchmark;
import com.revature.model.Todo;

@Component
public class TodoService {

	private final List<Todo> todos = new ArrayList<>();
	
	public TodoService() {
		for (int i = 0; i < 100; i++) 
			todos.add(new Todo(i, "Title: " + i, "Description: " + i));
	}
	
	public List<Todo> getAllTodos() {
		return new ArrayList<>(todos);
	}
	
	@Benchmark
	public Todo getById(int id) {
		return todos.get(id);
	}
	
	public Todo createTodo(Todo todo) {
		if (todos.add(todo)) 
			return todo;
		return null;
	}
	
}
