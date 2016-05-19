package test;

public class Guess {
	public static void main(String[] args) {
		System.out.println("在1-100范围内,现在开始证实");
		if (Testify_Guess(1, 100))
			System.out.print("成立");
	}
	
	public static boolean Testify_Guess(int low, int high) {
		int i, j = 0;
		boolean flag = true;
		for (i = 0; i <=high; i++) {
			if (i % 2 == 0 && i > 2) {
				if(isGoldbach(i)) {
					j++;
					if (j == 5) {
						System.out.println();
						j = 0;
					}
				} else {
					flag = false;
					break;
				}			
			}
		}
		return flag;
	}
	
	public static boolean isGoldbach(int a) {
		int i;
		boolean flag = true;
		for (i = 1; i <= a/2; i++) {
			if ( isPrime(i) && isPrime(a - i)) {
				flag = true;
				System.out.print(a + " = " + i + "+" + (a - i) + "  ");
				break;
			}
		}
		return flag;
	}
	
	public static  boolean isPrime(int i) {
		int n;
		boolean flag = true;
		if (1 == i)
			flag = false;
		for (n = 2; n <= (i - 1)/2; n++) {
			if (i % n == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
