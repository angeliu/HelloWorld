package test;

import java.util.Scanner;
import java.util.Stack;

public class TestStack {
	public int[] getNext(String t) {
		if(t==null || t.length() == 0)
			return null;
		int[] next = new int[t.length()];
		int i = 0;
		int j = -1;
		next[0] = -1;
		while(i < t.length() - 1) {
			if (j == -1 || t.charAt(i) == t.charAt(j)){
				++i;
				++j;
				if(t.charAt(i) == t.charAt(j))
					next[i] = next[j];
				else 
					next[i] = j;
				
			}else{
				j = next[j];
			}
		}
		
		return next;
	}
	public int KMP(String s, String t) {
		int ans = -1;
		int i = 0;
		int j = 0;
		int[] next = getNext(t);
		while(i < s.length()) {
			if(j == -1 || s.charAt(i) == toString().charAt(j)){
				i++;
				j++;
			} else {
				j = next[j];
			}
			if(j == t.length()) {
				ans = i - t.length();
				break;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		TestStack ts = new TestStack();
		int[] res = ts.getNext("aba");
		for(int tmp: res) {
			System.out.println(tmp);
		}
	}
}
