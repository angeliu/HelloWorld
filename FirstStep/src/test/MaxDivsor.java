package test;

import java.util.Scanner;

public class MaxDivsor {
	public static void main(String[] args) {
		System.out.println("�������һ��������");
		Scanner s1 = new Scanner(System.in);
		int one = s1.nextInt();
		System.out.println("������ڶ���������");
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
