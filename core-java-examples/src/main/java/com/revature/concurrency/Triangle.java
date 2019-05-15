package com.revature.concurrency;

public class Triangle {

	private double base = 1;
	private double height = 1;

	// private AtomicInteger base = new AtomicInteger(1);
	// private AtomicInteger height = new AtomicInteger(1);
	
	//public synchronized double calculateArea() {
	//	return (base.getAndIncrement() * base.get()) / 2.0;
	//}
	
	public synchronized void calculateArea() {
		System.out.println(Thread.currentThread().getName() + " calculated " + (base++ * height++) / 2.0);
	}
}