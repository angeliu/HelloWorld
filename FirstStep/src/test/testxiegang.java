package test;

import java.util.Scanner;


public class testxiegang {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String test = sc.nextLine();
		String[] te = test.split("/");
		for(String tmp : te) {
			System.out.println(tmp);
		}
	}
}
