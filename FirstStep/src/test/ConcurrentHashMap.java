package test;

import java.util.Hashtable;

public class ConcurrentHashMap {
	private static ConcurrentHashMap map = new ConcurrentHashMap();
	public static void main(String[] args) {
		while(true)
			new MyThread1();
	}
	
}

class Person {
	String name = "No name";
	public Person(String nm) {
		name = nm;
	}
	public Person() {
		
	}
}
class Employee extends Person {
	String empID = "0000";
	public Employee(String id) {
		empID = id;
	}
}
class MyThread extends Thread {
//	public void run() {
//		System.out.println("run");
//		this.test2();
//		this.test1();
//	}
	public synchronized void test1(){
		System.out.println("test1");
	}
	public synchronized void test2(){
		System.out.println("test2");
	}
}

class MyThread1 implements Runnable {
	public void run() {
		
	}
}