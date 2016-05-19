package test;

public class StairsFlight {
	public static void main(String[] args) {
		int x = 7, i, res = 0;
		boolean flag = false;
		for (i = 1; i <= 50; i++) {
			if ((x % 2 == 1) && (x % 3 == 2) && (x % 5 == 4) && (x % 6 == 5)) {
				res = x;
				flag = true;
				break;
			}
			x = 7 * (i + 1);
		}
		if (true == flag) {
			System.out.println(res);
		}
		else
			System.out.println("²»Âú×ã");
	}
}
