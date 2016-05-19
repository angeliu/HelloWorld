package test;

import java.util.Scanner;

public class MaxDivsor {
	public static void main(String[] args) {
		System.out.println("请输出第一个正数：");
		Scanner s1 = new Scanner(System.in);
		int one = s1.nextInt();
		System.out.println("请输入第二个整数：");
		Scanner s2 = new Scanner(System.in);
		int two = s2.nextInt();
		int max = commonDivisor(one, two);
		System.out.println(max);
	}
	public static int commonDivisor(int one, int two) {
		int max = (two == 0) ? one : commonDivisor(two, one % two);
		return max;
	}
}
