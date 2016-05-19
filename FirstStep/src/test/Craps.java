package test;

import java.io.IOException;

public class Craps {
	public static void main(String[] args) throws IOException {
		final int WAN = 0;
		final int LOST = 1;
		final int MID = 2;
		boolean flag = true;
		int outCome = MID;
		int sum;
		int point = 0;
		while (true) {
			System.in.read();
			if (flag) {
				sum = getPoint();
				System.out.println(sum);
				switch (sum) {
				case 7:
				case 11:
					outCome = WAN;
					break;
				case 2:
				case 3:
				case 12:
					outCome = LOST;
					break;
				default:
					flag = false;
					outCome = MID;
					point = sum;
					break;
				}
						
			} else {
				sum = getPoint();
				System.out.print("\n玩家第二次掷出的点数和：" + sum);
				if (sum == point) {
					outCome = WAN;
				} else if (sum == 7)
					outCome = LOST;
			}
			if (outCome == MID) {
				System.out.println("未分胜负，再掷一次");
			}
			else {
				if (outCome == WAN) {
					System.out.println("玩家胜利");
				}
				else 
					System.out.println("玩家失败");
				System.out.println("再玩一次");
				if (System.in.read() == 'n') {
					System.out.println("游戏结束");
					break;
				}
				flag = true;
			}
		}
	}
	public static int getPoint() {
		int roll = ((int) (Math.random() * 6) + (int) (Math.random() * 6));
		if (roll < 2)
			roll = 2;
		return roll;
	}
}
