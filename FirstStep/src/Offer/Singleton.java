package Offer;



public class Singleton {
	private volatile static Singleton instance = null;
	private Singleton(){	
	}
	public static synchronized Singleton getSingleton() {
		if(instance == null) {
				instance = new Singleton();
		}
		return instance;
	}
}
