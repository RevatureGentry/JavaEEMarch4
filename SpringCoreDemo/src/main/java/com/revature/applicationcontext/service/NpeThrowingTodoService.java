package com.revature.applicationcontext.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.applicationcontext.model.Todo;

//@Component
public class NpeThrowingTodoService implements TodoService {

	private String thisVariableCanBeAnything;
	
	public NpeThrowingTodoService() {
		thisVariableCanBeAnything.chars();
	}
	
	
	@Override
	public List<Todo> getAllTodos() {
		return new ArrayList<>();
	}

}
