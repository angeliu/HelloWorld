package TestThread;


public class TestLock implements Runnable {
	
	 int b = 10;
	
	public synchronized void m1() {
		b = 1000;
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("b1=" + b);
	}
	
	public	synchronized void m2() {
		try {
		Thread.sleep(2500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		b = 2500;
		
		System.out.println("b2=" + b );
	}
	
	public void run() {
		m1();
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestLock tt = new TestLock();
		Thread t = new Thread(tt);
		
		t.start();
		//Thread.sleep(1000);
		tt.m2();
		System.out.println("b3=" + tt.b);
	}
}