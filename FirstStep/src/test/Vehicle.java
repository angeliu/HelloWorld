package test;

public class Vehicle {
	public static void main(String[] args)
	{
		
		Vehicle v1 = new Vehicle();
		Vehicle v2 = new Vehicle(10.5f,30.5f,"lcb");
		
		System.out.println(v1.getName());
		v1.Print();
		System.out.println(v2.getName());
		v2.Print();
		
		
	}
	
	Vehicle()
	{
		speed = 0;
		angle = 0;
		name = null;
		
	}
	
	Vehicle(float speed,float angle,String name)
	{
		this.speed = speed;
		this.angle = angle;
		this.name = name;
	}
	
	public String getName()
	{
		return name;
		
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void changeSpeed(float speed)
	{
		this.speed = speed;
	}
	public void stop()
	{
		this.speed = 0;
	}
	
	
	
	
	public static  void Print()
	{
		System.out.println(idNum);
		
	}
	
	private float speed ;
	private float angle;
	private String name;
	private static long idNum;
	private static  long nextID = 0;
	{
		idNum = nextID++;
	}
	
	public String toString()
	{
		return name ;
	}
}


