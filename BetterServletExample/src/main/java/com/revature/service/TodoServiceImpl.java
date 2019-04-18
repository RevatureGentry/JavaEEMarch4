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
	public List<Todo> getAllCurrentUserTodos(HttpServletRequest request, HttpServletResponse response) {
		final String username = (String) request.getSession().getAttribute("currentUser");
		final String role = (String) request.getSession().getAttribute("role");
		
		if (username == null || role == null) {
			try {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (role.equals("employee") || role.equals("manager")) {
			return dao.getAllTodosByUsername(username);
		}
		
		return null;
	}
	
	@Override
	public List<Todo> getAllTodos(HttpServletRequest request, HttpServletResponse response) {
		final String username = (String) request.getSession().getAttribute("currentUser");
		final String role = (String) request.getSession().getAttribute("role");
		
		if (username == null || role == null) {
			try {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (role.equals("manager")) {
			return dao.getAllTodos();
		} else {
			return dao.getAllTodosByUsername(username);
		}
	}

	@Override
	public Todo createTodo(HttpServletRequest request, HttpServletResponse response) {
		final String username = (String) request.getSession().getAttribute("currentUser");
		final String role = (String) request.getSession().getAttribute("role");
		
		if (username == null || role == null) {
			try {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			Todo todo = mapper.readValue(request.getInputStream(), Todo.class);
			return dao.createTodo(todo, username);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	
}
