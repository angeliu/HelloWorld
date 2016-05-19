package test;

import java.util.Scanner;



public class TestMicr3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[][] rules = new char[110][110];
		int n = sc.nextInt();
		int m = sc.nextInt();
		String[] strs = new String[n];
		for (int i = 0; i < n; i++) {
			strs[i] = sc.next();
			for (int j = 0; j < m; j++) {
				rules[i][j] = strs[i].charAt(j);
			}
			
		}
		
		int[][][] dp = new int[n + 1][m + 1][2];
		if (rules[0][0] == 'b')
			dp[0][0][0] = 1;
		else
			dp[0][0][0] = 0;
		//dp[0][0][1] = (rules[0][0] == 'b' ? 1 : 0) + (rules[0][1] != 'b' ? 1 : 0);
		dp[0][0][1] = (rules[0][0] == 'b' ? 1 : 0);
		for (int i = 0; i < n; i++)
			rules[i][m] = 'b';
		for (int i = 0; i < m; i++)
			rules[n][i] = 'b';
		
		int tmp = 0;
		for (int i = 1; i < m; i++) {
			if (rules[0][i] == 'b')
				tmp++;
			dp[0][i][0] = tmp;
			dp[0][i][1] = tmp + (rules[0][i + 1] != 'b' ? 1 : 0);
		}
		tmp = (rules[0][1] != 'b' ? 1 : 0);
		for (int i = 1; i < n; i++) {
			if (rules[i][0] == 'b')
				tmp++;
			dp[i][0][1] = tmp;
			dp[i][0][0] = tmp + (rules[i + 1][0] != 'b' ? 1 : 0);
		}
		
		for (int i = 1; i < n; i++) {
			for(int j = 1; j < m; j++) {
				dp[i][j][0] = Math.min(dp[i][j - 1][0] + (rules[i][j] == 'b' ? 1 : 0), dp[i][j - 1][1] + (rules[i + 1][j - 1] != 'b' ? 1 : 0) + (rules[i][j] == 'b' ? 1 : 0));
				dp[i][j][1] = Math.min(dp[i - 1][j][1] + (rules[i][j] == 'b' ? 1 : 0), dp[i - 1][j][0] + (rules[i - 1][j + 1] != 'b' ? 1 : 0) + (rules[i][j] == 'b' ? 1 : 0));
			}
		}
		
		System.out.println(Math.min(dp[n - 1][m - 1][0], dp[n - 1][m - 1][1]));
	}
}
