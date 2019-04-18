package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.util.ConnectionFactory;

public class DispatcherServlet extends HttpServlet  {

	private static final long serialVersionUID = 1L;
	private final ObjectMapper mapper = new ObjectMapper();

	public DispatcherServlet() {
		ConnectionFactory.initializeDatabase();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.getOutputStream().write(mapper.writeValueAsBytes(Dispatcher.processGetRequest(req, resp)));
	}
}
