package com.revature.web;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.TodoService;
import com.revature.service.TodoServiceImpl;

public class Dispatcher {

	private static final TodoService service = new TodoServiceImpl();
	
	private Dispatcher() {}
	
	public static Object processGetRequest(HttpServletRequest request, HttpServletResponse response) {
		final String uri = request.getRequestURI().replace("/BetterServletExample/api", "");
		System.out.println("Inside Dispatcher: " + request.getMethod() + " request going to " + uri);
		switch(uri) {
		case "/todos":
			return service.getAllTodos(request, response);
		default: 
			return Collections.singletonMap("message", "Not yet implemented");
		}
	}
}
