package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;



public class Solution {
	public int maxProfix(int[] prices) {
		if(prices == null || prices.length < 2)
			return 0;
		int n = prices.length;
		int[] sell = new int[n];
		int[] cooldown = new int[n];
		sell[1] = prices[1] - prices[0];
		for(int i = 2; i < n; i++) {
			cooldown[i] = Math.max(sell[i - 1], cooldown[i - 1]);
			sell[i] = prices[i] - prices[i - 1] + Math.max(sell[i - 1], cooldown[i - 2]);
		}
		return Math.max(sell[n - 1], cooldown[n - 1]);
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		double a = 17.1;
		double b = 017.1;
		System.out.println(a == b);
//		List<String> list = s.letterCombinations("23");
//		for(int i = 0; i < list.size(); i++)
//			System.out.println(list.get(i));
	}
}
