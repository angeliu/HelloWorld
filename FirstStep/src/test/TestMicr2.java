package test;

import java.util.Scanner;



public class TestMicr2 {
	
	public static String turnBinary(String tmp) {
		String s1 = Integer.toBinaryString(Integer.valueOf(tmp)).toString();
		while(s1.length() < 8)
			s1 = "0" + s1;
		return s1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String[] rules = new String[n];
		String[] ipadds = new String[m];
		for (int i = 0; i < n; i++) {
			String s1 = sc.next();
			String s2 = sc.next();
			rules[i] = s1 + " " + s2;
			
		}
		
		for (int k = 0; k < m; k++) {
			ipadds[k] = sc.next();
			
		}
		
		for (int i = 0; i < ipadds.length; i++) {
			int j;
			for ( j = 0 ; j < rules.length; j++) {
				String[] rul = rules[j].split(" ");
				
				String[] masks = rul[1].split("/");
				
				if(rul[0].equals("deny")) {
					if (masks.length == 1) {
						if (ipadds[i].equals(masks[0])) {
							System.out.println("NO");
							break;
						}
							
						
						else {
							continue;
						}
					} else  {
						
						String[] ips = masks[0].split("\\.");
						
						StringBuilder sb = new StringBuilder();
						for(int k = 0; k < ips.length; k++) {
							sb.append(turnBinary(ips[k]));
						}
						
						StringBuilder sb1 = new StringBuilder();
						String[] ipadd = ipadds[i].split("\\.");
						for(int t = 0; t < ipadd.length; t++) {
							sb1.append(turnBinary(ipadd[t]));
						}
						String str1 = sb.toString();
					
						String str2 = sb1.toString();
						
						int k1 = 0;
						for (k1 = 0; k1 < Integer.valueOf(masks[1]); k1++) {
							if (str1.charAt(k1) == str2.charAt(k1))
								continue;
							else
								break;
						}
						if (k1 == Integer.valueOf(masks[1])) {
							System.out.println("NO");
							break;
						}
							
					}
				} else {
					if (masks.length == 1) {
						if (ipadds[i].equals(masks[0]))
						{
							System.out.println("YES");
							break;
						}	
						else {
							continue;
						}
					} else {
						StringBuilder sb = new StringBuilder();
						String[] ips = masks[0].split("\\.");
						for(int k = 0; k < ips.length; k++) {
							sb.append(turnBinary(ips[k]));
						}
						StringBuilder sb1 = new StringBuilder();
						String[] ipadd = ipadds[i].split("\\.");
						for(int t = 0; t < ipadd.length; t++) {
							sb1.append(turnBinary(ipadd[t]));
						}
						
						String str1 = sb.toString();
						String str2 = sb1.toString();
						int k1 = 0;
						for (k1 = 0; k1 < Integer.valueOf(masks[1]); k1++) {
							if (str1.charAt(k1) == str2.charAt(k1))
								continue;
							else
								break;
						}
						if (k1 == Integer.valueOf(masks[1]))
						{
							System.out.println("YES");
							break;
						}
							
					}
				}
				
			}
			if (j == rules.length)
				System.out.println("YES");
		}
			
	}
}
