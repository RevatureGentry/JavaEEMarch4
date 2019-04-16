package com.revature.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.TodoDao;
import com.revature.dao.TodoDaoImpl;
import com.revature.model.Todo;

public class TodoServiceImpl implements TodoService {

	private final TodoDao dao = new TodoDaoImpl();
	
	@Override
	public List<Todo> getAllTodos(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside TodoServiceImpl");
		return dao.getAllTodos();
	}

}
