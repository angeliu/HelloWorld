package test;

import java.security.cert.PolicyQualifierInfo;

public class Queens {
	static int count = 0;
	public static void main(String[] args) {
		int[][] pawn = new int[8][8];
		int i, cols;
		for (i = 0; i < 8; i++) {
			for (cols = 0; cols < 8; cols++) {
				pawn[i][cols] = 0;
			}
		}
		int count = soveIng(0, 8, pawn);
		System.out.println("count" + count);
	}
	public static int soveIng(int row, int cols, int[][] pawn) {
		int j;
		int k, t;
		int[][] pawn2 = new int[8][8];
		for (int i = 0; i < 8; i++) {
			for (j = 0; j < 8; j++) {
				pawn2[i][j] = pawn[i][j];
			}
		}
		if (row == 8) {
			System.out.println("第" + (count + 1) + "种方法：");
			for (k = 0; k < 8; k++) {
				for (t = 0; t < 8; t++) {
					System.out.print(pawn2[k][t]);
				}
				System.out.println();
			}
			count++;
		} else {
			for ( j = 0; j < cols; j++) {
				if (isPlaced(row, j, pawn)) {
					for (int i = 0; i < 8; i++)
						pawn2[row][i] = 0;
					pawn2[row][j] = 1;
					soveIng(row + 1, cols, pawn2);
				}
			}
		}
		return count;	
	}
	public static boolean isPlaced(int row, int cols, int[][] pawn) {
		int i, k;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		boolean flag5 = false;
		for (i = 0; i < 8; i++) {
			if (pawn[i][cols] != 0) {
				flag1 = true;
				break;
			}
		}
		for (i =row, k = cols; i >= 0 && k >= 0; i--, k--) {
			if (pawn[i][k] != 0) {
				flag2 = true;
				break;
			}
		}
		for (i =row, k = cols; i < 8 && k < 8; i++, k++) {
			if (pawn[i][k] != 0) {
				flag3 = true;
				break;
			}
		}
		for (i = row, k = cols; i >= 0 && k < 8; i--, k++) {
			if (pawn[i][k] != 0) {
				flag4 = true;
				break;
			}
		}
		for (i = row, k = cols; i < 8 && k >= 0; i++, k--) {
			if (pawn[i][k] != 0) {
				flag5 = true;
				break;
			}
		}
		if (flag1 || flag2 || flag3 || flag4 || flag5)
			return false;
		else
			return true;
	}
}
