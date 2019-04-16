package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.util.ConnectionFactory;

public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final ObjectMapper mapper = new ObjectMapper();
	
	public DispatcherServlet() {
		// NOTE: This is only necessary in our example that uses an H2 database
		ConnectionFactory.initializeDatabase();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entering DispatcherServlet");
		resp.setContentType("application/json");
		
		// getOutputStream() because it will write the response more efficiently than getWriter().println()
		// mapper.writeValueAsBytes() converts whatever the Dispatcher returns into a byte[], which getOutputStream().write() accepts
		// Dispatcher.process() returns whatever resource we have available at the HttpServletRequest's URI
		resp.getOutputStream().write(mapper.writeValueAsBytes(Dispatcher.process(req, resp)));
		System.out.println("Response sent successfully!");
	}
}
