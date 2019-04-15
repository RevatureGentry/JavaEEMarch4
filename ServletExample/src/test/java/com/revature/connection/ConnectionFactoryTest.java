package com.revature.connection;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.dao.TodoDao;
import com.revature.dao.TodoDaoImpl;
import com.revature.model.Todo;
import com.revature.util.ConnectionFactory;

public class ConnectionFactoryTest {
	
	private TodoDao dao = new TodoDaoImpl();
	
	@BeforeClass
	public static void initializeDatabase() {
		ConnectionFactory.initializeDatabase();
	}
	
	@Test
	public void getAllTodosShouldReturn1() {
		List<Todo> todos = dao.getAllTodos();
		assertEquals(1, todos.size());
	}
}
