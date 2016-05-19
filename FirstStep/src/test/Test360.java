package test;

import java.util.Scanner;

import javax.print.DocFlavor.BYTE_ARRAY;

import org.apache.xalan.xsltc.compiler.sym;

public class Test360 {
	public void potReplace() {
		Scanner sc = new Scanner(System.in);
		String str = null;
		int index = 0;
		String pot;
		int count = 0;
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			str = sc.next();
			if (n == 0 && str.isEmpty())
				continue;
			for (int i = 0; i < m; i++) {
				index = sc.nextInt();
				pot = sc.next();
				str = str.substring(0, index - 1) + pot + str.substring(index);
				for (int j = 0; j < str.length() - 1; j++) {
					if (str.charAt(j) == str.charAt(j + 1)) {
						if (str.charAt(j) == '.')
							count ++;
					}
				}
				System.out.println(count);
				count = 0;
			}
		}
	}
	public static void main(String[] args) {
		String s = "allow 1.2.3.4/30";
		String[] st1 = s.split("/");
		for(String st: st1)
			System.out.println(st);
		//System.out.println(Integer.toBinaryString(Integer.valueOf(s)));
		
	}
}
