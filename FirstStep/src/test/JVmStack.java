package test;

public class JVmStack {
	private int count = 0;
	public void test () {
		count ++;
		test();
	}
	
	public static void main(String[] args) {
		JVmStack jvm = new JVmStack();
		try {
			jvm.test();
		} catch (Exception e) {
			System.out.println(jvm.count);
			throw e;
			// TODO: handle exception
		}
	}
}
