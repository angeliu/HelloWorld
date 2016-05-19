package test;

import java.util.Scanner;

import Offer.ListNode;

public class Factorial_1 {
	public static void main(String[] args) {
		System.out.println("请输入正整数N:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(n - lowLocation(n) + 1);
	}
	public static int getZero(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			int j = i;
			while (j % 5 == 0) {
				sum++;
				j /= 5;
			}
		}
		return sum;
	}
	public static int lowLocation(int n) {
		int count = 0;
//		while (n != 0) {
//			
//			n >>= 1;
//			count += n;
//		}
//		return count + 1;
		while (n != 0) {
			n &= (n-1);
			count ++;
		}
		
		return count;
	}
	public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
        	return null;
		ListNode  slow = head;
        ListNode  fast = head;
        while (fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if (slow == fast) {
        		break;
        	}
        }
        if (fast == null || fast.next == null)
        	return null;
        slow = head;
        while (slow != fast) {
        	slow = slow.next;
        	fast = fast.next;
        }
        return fast;       	
    }
}
