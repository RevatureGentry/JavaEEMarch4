package com.revature.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.TodoDao;
import com.revature.dao.TodoDaoImpl;
import com.revature.model.Todo;

public class TodoServiceImpl implements TodoService {

	private final TodoDao dao = new TodoDaoImpl();
	private final ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public List<Todo> getAllTodos(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside TodoServiceImpl");
		return dao.getAllTodos();
	}

	@Override
	public Todo createTodo(HttpServletRequest request, HttpServletResponse response) {
		try {
			// From the HTTP Request body, parse the JSON into a Todo Object
			Todo todo = mapper.readValue(request.getInputStream(), Todo.class);
			return dao.createTodo(todo);
		} catch (IOException e) {
			// TODO: Refine exception handling logic
			return null;
		}
	}
}
