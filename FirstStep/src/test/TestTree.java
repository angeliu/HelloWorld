package test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.apache.axis2.transport.RequestResponseTransport;
import org.apache.bcel.generic.NEWARRAY;
import org.apache.log4j.spi.RootCategory;
import org.apache.xpath.axes.ReverseAxesWalker;
import org.jaxen.util.StackedIterator;

public class TestTree {
	public void preOrderTree(TreeNode root) {
		if(root == null)
			return;
		System.out.println(root.val);
		preOrderTree(root.left);
		preOrderTree(root.right);
	}
	public void preOrderTree1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		while(p != null || !stack.isEmpty()) {
			while(p != null) {
				System.out.println(p.val);
				stack.push(p);
				p = p.left;
			}
			if(!stack.isEmpty()) {
				p = stack.peek();
				stack.pop();
				p = p.right;
			}
		}
	}
	public void inOrderTree(TreeNode root) {
		if(root == null)
			return;
		
		inOrderTree(root.left);
		System.out.println(root.val);
		inOrderTree(root.right);
	}
	public void inOrderTree1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		while(p != null || !stack.isEmpty()) {
			while(p != null) {
				
				stack.push(p);
				p = p.left;
			}
			if(!stack.isEmpty()) {
				p = stack.peek();
				System.out.println(p.val);
				stack.pop();
				p = p.right;
			}
		}
	}
	public void postOrderTree(TreeNode root) {
		if(root == null)
			return;
		
		postOrderTree(root.left);
		postOrderTree(root.right);
		System.out.println(root.val);
	}
	public void postOrderTree1(TreeNode root) {
		Stack<TreeNode>  stack = new Stack<>();
		TreeNode cur, pre = null;
		stack.push(root);
		while(!stack.isEmpty()) {
			cur = stack.peek();
			if((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
				System.out.println(cur.val);
				stack.pop();
				pre = cur;
			} else
			{
			if(cur.right != null)
				stack.push(cur.right);
			if(cur.left != null)
				stack.push(cur.left);
			}
		}
	}
	public void level(TreeNode root) {
		ArrayList<TreeNode> list = new ArrayList<>();
		list.add(root);
		while(!list.isEmpty()) {
			TreeNode p = list.get(0);
			list.remove(0);
			System.out.println(p.val);
			if(p.left != null)
				list.add(p.left);
			if(p.right != null)
				list.add(p.right);
		}
	}
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);
		t2.left = t1;
		t3.left = t2;
		t3.right = t4;
		t5.left = t3;
		t5.right = t7;
		t7.left = t6;
		t7.right = t8;
		t8.right = t9;
		TestTree tt = new TestTree();
		tt.level(t5);
		
	}
}
