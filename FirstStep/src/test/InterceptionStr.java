package test;


import java.util.Scanner;

public class InterceptionStr {
	static String ss;
	static int n;
	public static void main(String[] args){
		System.out.println("�������ַ�����");
		Scanner  sc = new Scanner(System.in);
		ss = sc.next();
		System.out.println("�������ֽ�����");
		Scanner sc1 = new Scanner(System.in);
		n = sc1.nextInt();
		interception(setValue());
	}
	public static String[] setValue(){
		String[] string = new String[ss.length()];
		for(int i = 0; i < string.length; i++){
			string[i] = ss.substring(i, i+1);
		}
		return string;
	}
	public static void interception(String[] string){
		int count = 0;
		String m = "[\u4e00-\u9fa5]";
		System.out.println("��ÿ" + n + "�ֽڻ��ֵ��ַ���������ʾ��");
		for (int i = 0; i < string.length; i++){
			if (string[i].matches(m))
				count = count + 2;
			else
				count = count + 1;
			if(count <= n){
				System.out.print(string[i]);
			}
			else
				break;
//			if (count < n){
//				System.out.print(string[i]);
//			} else if (count == n) {
//				System.out.print(string[i]);
//				count = 0;
//				System.out.println();
//			} else {
//				count = 0;
//				System.out.println();
//			}
		}
	}
}
