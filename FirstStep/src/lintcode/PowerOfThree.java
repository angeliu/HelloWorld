package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;


class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
public class PowerOfThree {
	public boolean isPorwerOfThree(int n)
	{
		if(n==0)
			return false;
		double res = Math.log(n)/Math.log(3);
		return n > 0 && Math.abs(res - Math.round(res)) < 10e-15;
		
	}
	public boolean isValid(String s) {
		if (s.length() == 0)
			return true;
		Map<Character, Character> map = new HashMap<Character,Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<s.length();i++)
		{
			char curr = s.charAt(i);
			if(map.containsKey(curr))
			{
				stack.push(curr);
			}
			else if(map.values().contains(curr))
			{
				if(!stack.empty() && map.get(stack.peek()) == curr)
					stack.pop();
				else
					return false;
			}
		}
		return stack.isEmpty();			
    }
	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null || head.next.next == null)
			return head;
		ListNode oddHead = new ListNode(0);
		ListNode evenHead = new ListNode(0);
		oddHead.next = head;
		evenHead.next = head.next;
		ListNode oddCur = head;
		ListNode evenCur = head.next;
		while(evenCur != null && evenCur.next != null)
		{
			oddCur.next = evenCur.next;
			evenCur.next = evenCur.next.next;
			oddCur = oddCur.next;
			evenCur = evenCur.next;
		}
		oddCur.next = evenHead.next;
		return oddCur.next;
    }
	
	public int myAtoi(String str) {
		
        if(str == null || str.length() < 1)
        	return 0;
       
        str = str.trim();
        char flag = '+';
        int i = 0;
        if(str.charAt(0) == '-'){
        	flag = '-';
        	i++;
        } else if(str.charAt(0) == '+') {
        	i++;
        }
        long res = 0;
        for(;i<str.length();i++)
        {
        	if(str.charAt(i) <'0'||str.charAt(i) >'9')
        		break;
        	res = res * 10 + (str.charAt(i) -'0');
        	if(res > Integer.MAX_VALUE)
        		break;
        		
        }
        if(flag == '-')
        	res = -res;
        if(res >= Integer.MAX_VALUE)
        	return Integer.MAX_VALUE;
        if(res <= Integer.MIN_VALUE)
        	return Integer.MIN_VALUE;
        return (int)res;
    }
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
        	return lists;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int parentNum = 1;
        int childNum = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!queue.isEmpty())
        {
        	TreeNode cur = queue.poll();
        	list.add(cur.val);
        	parentNum--;
        	if(cur.left != null){
        		queue.add(cur.left);
        		childNum++;
        	}
        	if(cur.right != null)
        	{
        		queue.add(cur.right);
        		childNum++;
        	}
        	if(parentNum == 0)
        	{
        		parentNum = childNum;
        		childNum = 0;
        		lists.add(list);
        		list = new ArrayList<Integer>();
        	}
        }
        for(int i=lists.size()-1;i>=0;i--)
        	res.add(lists.get(i));
        return res;
        
    }
	public static void main(String[] args) {
		System.out.println(new PowerOfThree().myAtoi("-"));
	}
}
