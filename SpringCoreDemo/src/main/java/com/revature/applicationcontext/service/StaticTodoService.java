package com.revature.applicationcontext.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.applicationcontext.model.Todo;

@Component
public class StaticTodoService implements TodoService {

	private final List<Todo> todos = new ArrayList<>();
	
	public StaticTodoService() {
		for (int i = 1; i < 101; i++) 
			todos.add(new Todo(i, "Title: " + i, "Description: " + i));
	}
	
	@Override
	public List<Todo> getAllTodos() {
		return new ArrayList<>(todos);
	}

	
}
