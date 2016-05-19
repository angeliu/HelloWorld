package test;

import org.kohsuke.rngom.digested.DPattern;

public class TestTX {
	public String reverseString(String str) {
		if (str == null || str.length() == 0)
			return null;
		String[] res = str.split(" ");
		System.out.println(res.length);
		StringBuilder sb = new StringBuilder();
		for (int i = res.length - 1; i >= 0; i--) {
			if (i == 0) {
				sb.append(res[0]);
			}
			else {
				sb.append(res[i]);
				sb.append(" ");
			}	
		}
		return sb.toString();
	}
	
	public void rect(int n) {
		int[][] arr = new int[n][n];
		
		int val = 1;
		int p = n;
		for (int i = 0; i < n/2 ; i++, p -= 2) {
			for (int col = i ; col < i + p ; col++) {
				arr[i][col] = val++;
			}
			for (int row = i + 1; row < i + p; row++) {
				arr[row][i + p - 1] = val++;
			}
			for (int col = i + p - 2; col >= i; col--)
				arr[i + p - 1][col] = val++;
			for (int row = i + p -2; row > i; row--)
				arr[row][i] = val++;
		}
		if (n % 2 != 0) arr[n/2][n/2] = val;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					System.out.print(arr[i][j]);
				else {
					System.out.print(" " + arr[i][j]);
				}
			}
		}
	}
	public int palindrome(String str) {
		if (str == null || str.length() == 0)
			return 0;
		int len = str.length();
		int[][] res = new int[len + 1][len + 1];
		for (int i = 0; i < len; i++) {
			res[i][i]=1;
			for (int j = 0; j < i; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					int left = j + 1;
					int right = i - 1;
					if (left > right)
						res[j][i] = 2;
					else
						res[j][i] = 2 + res[left][right];
				}
				else {
					if (i == 1)
						res[j][i] = 1;
					else {
						res[j][i] = Math.max(res[j][i - 1], res[j + 1][i]);
					}											
				}
				System.out.println("res:"+ res[j][i] + " j: " + j + " i:" + i);
			}
		}
		return res[0][len - 1];
	}
	public int palindrome1(String str) {
		if (str == null || str.length() == 0)
			return 0;
		int len = str.length();
		int[][] res = new int[len + 1][len + 1];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len ; j++) {
				res[i][j] = 1;
			}
		}
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < len - i; j++) {
				if (str.charAt(j) == str.charAt(j + i)) {
					int left = j + 1;
					int right = j + i - 1;
					if (left > right)
						res[j][j + i] = 2;
					else
						res[j][j + i] = 2 + res[left][right];
				}
				else {
					if (i == 1)
						res[j][j + i] = 1;
					else
						res[j][j + i] = Math.max(res[j][j + i - 1], res[j + 1][j + i]);
				}
				System.out.println("res:"+ res[j][i] + " j: " + j + " i:" + (j + i));
			}
		}
		return res[0][len - 1];
	}
	public int palindrome2(String str) {
		if (str == null || str.length() == 0)
			return 0;
		StringBuilder  sb = new StringBuilder(str);
		String tmp = sb.reverse().toString();
		int len = str.length();
		int[][] res = new int[len + 1][len + 1];
		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= len; j++) {
				if (str.charAt(i - 1) == tmp.charAt(j - 1)) {
					res[i][j] = res[i - 1][j - 1] + 1;
				}
				else {
						res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
																
				}
			//	System.out.println("res:"+ res[j][i] + " j: " + j + " i:" + i);
			}
		}
		return res[len][len];
	}
	public static int [][] arr = {
			{0,0,8,0,0},
			{0,0,0,9,0},
			{0,7,0,0,0},
			{0,0,6,0,0}
			
	};
	public int maxPrice(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		int [] res = new int[n];
		for (int i = 0; i< n; i++)
			res[i] = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0)
					res[j] += arr[i][j];
				else {
					res[j] = Math.max(res[j] + arr[i][j], res[j - 1] + arr[i][j]);
				}
				
				
			}
		}
		return res[n - 1];
	}
	public static void main(String[] args) {
		TestTX tt = new TestTX();
		//System.out.println(tt.reverseString("I     come  from china."));
		//System.out.println("\t" + "test");
		//System.out.println("123456789123456789123456789");
		//tt.rect(3);
		System.out.println(tt.palindrome2("cabbeaf"));
		//System.out.println(tt.maxPrice(arr));
	}
}
