package test;

public class PortFolio {
	static int num = 5, M = 5;
	static int k;
	static boolean find = false;;
	static int[] logo = new int[num];
	static int[] stamp = {0, 1, 4, 12, 21};
	
	public static boolean Comable(int n, int value) {
		if (n >= 0 && value == 0) {
			find = true;
			int sum = 0;
			for (int i = 0; i < num && logo[i] != 0; i++) {
				sum += stamp[logo[i]];
				System.out.print(stamp[logo[i]] + ",");
			}
			System.out.println("×ÜÊý" + sum);
		} else {
			for (int i = 1; i < M && !find && n > 0; i++) {
				if (value - stamp[i] >= 0) {
					logo[k++] = i;
					Comable(n - 1,  value - stamp[i]);
					logo[--k] = 0;
				}
			}
		}
		return find;
	}
	public static void main(String[] args) {
		for(int i = 1; Comable(num, i); i++, find = false);
	}
}
