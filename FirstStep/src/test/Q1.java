package test;

public class Q1 {
	{  System.out.println("run initializer"); }
	
	public static void main(String[] args)
	{
		new Q1();new Q1(); new Q1();
	}
	
	static { 
		System.out.println("run static initializer");
	}

}
