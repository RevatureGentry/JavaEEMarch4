package com.revature.concurrency;

public class TriangleTask implements Runnable {

	private Triangle triangle;
	
	public TriangleTask(Triangle triangle) {
		this.triangle = triangle;
	}
	
	// Callable<T>
	
	public void run() {
		triangle.calculateArea();
	}
}