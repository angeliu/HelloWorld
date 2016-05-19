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
				System.out.print("\n��ҵڶ��������ĵ����ͣ�" + sum);
				if (sum == point) {
					outCome = WAN;
				} else if (sum == 7)
					outCome = LOST;
			}
			if (outCome == MID) {
				System.out.println("δ��ʤ��������һ��");
			}
			else {
				if (outCome == WAN) {
					System.out.println("���ʤ��");
				}
				else 
					System.out.println("���ʧ��");
				System.out.println("����һ��");
				if (System.in.read() == 'n') {
					System.out.println("��Ϸ����");
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
