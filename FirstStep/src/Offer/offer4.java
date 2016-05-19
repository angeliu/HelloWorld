package Offer;

import java.util.Scanner;
import java.util.Stack;



public class offer4 {
	public void printReverse(ListNode head) {
		if(head != null) {
			if(head.next != null) {
				printReverse(head.next);
			}
			System.out.println(head.val);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ListNode l1 = new ListNode(3);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		offer4 offer = new offer4();
		offer.printReverse(l1);
		
	}
}
