package com.revature.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Todo;

public interface TodoService {

	List<Todo> getAllTodos(HttpServletRequest request, HttpServletResponse response);
	Todo createTodo(HttpServletRequest request, HttpServletResponse response);
}
