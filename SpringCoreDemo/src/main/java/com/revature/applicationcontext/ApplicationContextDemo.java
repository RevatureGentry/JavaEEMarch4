package com.revature.applicationcontext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.applicationcontext.service.TodoService;

public class ApplicationContextDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext("com.revature.applicationcontext");
		// The IoC Container is ready to be used
		
		// TodoService staticTodoService = new StaticTodoService();
//		TodoService staticTodoService = (TodoService) context.getBean("dynamicTodoService");
//		staticTodoService.getAllTodos().forEach(System.out::println);
		
		System.out.println("=========================== Singleton ==============================");
		for (int i = 0; i < 10; i++) {
			System.out.println(context.getBean("singletonScopedBean"));
		}
		
		System.out.println("=========================== Prototype ==============================");
		for (int i = 0; i < 10; i++) 
			System.out.println(context.getBean("prototypeScopedBean"));
	}
}
