package com.revature;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.revature.beans.TodoService;

/*
 * Both @Configuration and @EnableAspectJAutoProxy are required for advice to be 
 * applied 
 */
@Configuration
@EnableAspectJAutoProxy
public class AspectsDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.revature");
		
		TodoService service = (TodoService) context.getBean("todoService");
		service.getAllTodos();
		System.out.println(service.getById(1));
		System.out.println(service.getById(50));
	}
}
