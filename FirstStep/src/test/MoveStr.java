package test;

import java.util.Scanner;

import org.apache.bcel.generic.RETURN;
import org.jvnet.substance.painter.BaseGradientPainter;

public class MoveStr {
	public static void main(String[] args) {
		System.out.println("�������ַ�����");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] ch = str.toCharArray();
		System.out.println("����ǰ���ַ���Ϊ" + str);
		int sum = beginMove(ch);
		System.out.println("���ַ�����'*'������Ϊ��" + sum);
	}
	public static int beginMove(char[] ch) {
		int i, j = ch.length - 1;
		for (i = j; j >= 0; j--) {
			if (ch[i] != '*') {
				i--;
			} else if (ch[j] != '*') {
				ch[i] = ch[j];
				ch[j] = '*';
				i--;
			}
		}
		System.out.println("����֮����ַ���Ϊ��" + new String(ch));
	return i + 1;
	}
	
}
