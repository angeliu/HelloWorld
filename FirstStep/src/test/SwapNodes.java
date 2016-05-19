package test;import java.util.ArrayList;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;

import javax.print.attribute.standard.NumberUpSupported;

import org.apache.axis2.jaxws.description.builder.TMAnnotationComposite;
import org.apache.commons.httpclient.methods.FileRequestEntity;
import org.apache.xpath.WhitespaceStrippingElementMatcher;

import Offer.ListNode;

public class SwapNodes {
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null )
        	return head;
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;
        ListNode cur = head;
        ListNode next = head;
        while(cur != null && cur.next != null) {
        	next = cur.next.next;
        	pre.next = cur.next;
        	cur.next.next = cur;
        	cur.next = next;
        	pre = cur;
        	cur = next;	
        }
        return res.next;
    }
	public String reverseString(String s) {
        if (s == null)
        	return s;
        char[] str = s.toCharArray();
        for(int i = 0 , j = str.length - 1; i < j; i++, j--) {
        	char tmp = str[i];
        	str[i] = str[j];
        	str[j] = tmp;
        }
        return new String(str);
    }
	
	
	public int integerBreak(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i <= n; i++) {
        	for(int j = 1; j < i; j++) {
        		arr[i] = Math.max(arr[i], j * arr[i - j]);
        		arr[i] = Math.max(arr[i], j * (i - j));
        	}
        }
        return arr[n];
    }
	public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
        	return "0";
        int[] arr = new int[num1.length() + num2.length()];
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int i , j;
        for(i = 0; i < char2.length; i++) {
        	int carry = 0;
        	for (j = 0; j < char1.length; j++) {
        		int v1 = char1[char1.length - 1 - j] - '0';
        		int v2 = char2[char2.length - 1 - i] - '0';
        		int value = v1 * v2 + carry + arr[arr.length - 1 - i -j];
        		carry = value / 10;
        		value = value % 10;
        		arr[arr.length - 1 - i - j] = value;
        	}
        	arr[arr.length - 1 - i - j] = carry;
        }
        
        String s = "";
        boolean flag = false;
        for (i = 0; i < arr.length; i++) {
        	if(arr[i] != 0)
        		flag = true;
        	if(flag) {
        		s += arr[i];
        	}
        }
        return s;
    }
	public int findMin(int[] nums) {
	      if (nums == null || nums.length == 0)
	    	  return Integer.MIN_VALUE;
	      int begin = 0;
	      int end = nums.length - 1;
	      while(begin < end) {
	    	  int mid = begin + (end - begin)/2;
	    	  if(nums[begin] == nums[mid]) {
	    		  if(nums[end] >= nums[mid])
	    			  end--;
	    		  else
	    			  begin++;
	    	  }
	    	  else if(nums[begin] < nums[mid]) {
	    		  if (nums[mid] > nums[end])
	    			  begin = mid + 1;
	    		  else
	    			  end = mid;
	    	  }
	    	  else
	    		  end = mid;  
	      }
	      return nums[begin];
	      
	}
	List<List<Integer>> res;
	ArrayList<Integer> list;
	public List<List<Integer>> permute(int[] nums) {
       res = new ArrayList<>();
       list = new ArrayList<>();
       int[] flags = new int[nums.length];
      getPermutation(nums, 0, flags);;
      return res;
    }
	 void getPermutation(int[] nums, int level, int[] flags) {
		 if(level == nums.length) {
			 res.add(new ArrayList<>(list)); 
		 }
		 for(int i = 0; i < nums.length; i++) {
			 if(flags[i] == 0) {
				 flags[i] = 1;
				 list.add(nums[i]);
				 getPermutation(nums, level + 1, flags);
				 list.remove(level);
				 flags[i] = 0;
			 }
		 }
	 }
	 public void sortColors(int[] nums) {
	      int[] count = new int[3];
	      for(int i = 0; i < nums.length; i++) {
	    	  count[nums[i]] ++;
	      }
	      int index = 0;
	      for (int i = 0; i < 3; i++) {
	    	  for (int j = 0; j < nums.length; j++) {
	    		  if(count[i]-- > 0)
	    			  nums[index++] = i;
	    	  }
	      }
	 }
	 public int[] productExceptSelf(int[] nums) {
	        if(nums == null || nums.length == 0)
	        	return nums;
	        int[] a = new int[nums.length];
	        for(int i = 0, left = 1; i < a.length; i++) {
	        	a[i] = left;
	        	left *= nums[i];
	        }
	        for(int j = a.length - 1, right = 1; j >= 0; j--) {
	        	a[j] *= right;
	        	right *= nums[j];
	        }
	        return a;
	  }
	 public int minPathSum(int[][] grid) {
	        if(grid == null || grid.length == 0 || grid[0].length == 0)
	        	return 0;
	        int m = grid.length;
	        int n = grid[0].length;
	       
	        for(int i = 0; i < m; i++) {
	        	for(int j = 0; j < n; j++) {
	        		if(i == 0 && j == 0) 
	        			grid[i][j] = grid[i][j];
	        		else if(i > 0 && j == 0)
	        			grid[i][j] = grid[i][j] + grid[i-1][j];
	        		else if(j > 0 && i == 0)
	        			grid[i][j] = grid[i][j] + grid[i][j-1];
	        		else {
	        			grid[i][j] = grid[i][j] + Math.min(grid[i-1][j], grid[i][j-1]);
	        		}
	        	}
	        }
	        return grid[m-1][n-1];
	    }
	 public int maxProfit(int[] prices) {
	        if(prices == null || prices.length == 0)
	        	return 0;
	        int profit = 0;
	        int minPrice = Integer.MAX_VALUE;
	        for(int i = 0; i < prices.length; i++) {
	        	minPrice = Math.min(minPrice, prices[i]);
	        	profit = Math.max(prices[i] - minPrice, profit);
	        }
	        return profit;
	    }
	 public ListNode reverseBetween(ListNode head, int m, int n) {
	        if (m == n)
	        	return head;
	        ListNode res = new ListNode(0);
	        res.next = head;
	        ListNode p = head;
	        ListNode pre = res;
	        for(int i = 1; i < m; i++) {
	        	pre = p;
	        	p = p.next;
	        }
	        pre.next = null;
	        ListNode first = p;
	        ListNode q = null;
	        for(; m <= n; m++) {
	        	q = pre.next;
	        	pre.next = p;
	        	p = p.next;
	        	pre.next.next = q;
	        }
	        first.next = p;
	        return res.next;
	        
	    }
	 
	 public static void main(String[] args) {
		SwapNodes sn = new SwapNodes();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		ListNode res = sn.reverseBetween(l1, 1, 2);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
			
		}
			
			
		
	}
}
