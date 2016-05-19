package Offer;

public class findNumber {
	public boolean find(int[][] a, int n) {
		if(a == null || a.length == 0 || a[0].length == 0)
			return false;
		int col = a[0].length;
		int row = a.length;
		int j = col - 1;
		int i = 0;
		while(i < row && j >= 0) {
			if(a[i][j] == n) {
				return true;
			}	
			else if(a[i][j] > n)
				j--;
			else 
				i++;
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] a = {
				{ 1,3,8,9},
				{2,4,9, 12}
		};
		findNumber fn = new findNumber();
		System.out.println(fn.find(a, -1));
	}
}
