package test;

import org.apache.xalan.xsltc.compiler.sym;

public class Card {
	public volatile static int test = 1;
	public static void main(String[] args) {
		final int N;
		int[] solitaire = new int[(N = 52) + 1];
		for (int i = 1; i <= N; i++) {
			solitaire[i] = i;
		}
		for (int i = 1; i <= N; i++) {
			int j = (int)(Math.random() * N);
			if (j == 0)
				j = 1;
			int mid = solitaire[i];
			solitaire[i] = solitaire[j];
			solitaire[j] = mid;
		}
		for (int i = 1; i <= N; i++) {
			switch ((solitaire[i] - 1) /13) {
			case 0:
				System.out.print("ºÚÌÒ");
				break;
			case 1:
				System.out.print("ºìÐÄ");
				break;
			case 2:
				System.out.print("ºì×©");
				break;
			case 3:
				System.out.print("ºÚÃ·");
				break;
			
			}
			
			int number = solitaire[i] % 13;
			switch(number) {
			case 0:
				System.out.print("K ");
				break;
			case 1:
				System.out.print("A ");
				break;
			case 12:
				System.out.print("Q ");
				break;
			case 11:
				System.out.print("J ");
				break;
			default:
				System.out.print(number + " ");
				break;	
			}
			if (i % 13 == 0)
				System.out.println("");
		}
		
		
	}
}
