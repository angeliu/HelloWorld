package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;





public class TestSort  {
	
	public static void main(String[] args) {
	    String[] a = {"123","231","43"};
	    TestSort ts = new TestSort();
	   
	  
		Arrays.sort(a,new TestSort().new  MyComparator());
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i] + " ");
		}
	}
	class MyComparator implements Comparator<String> {

		@Override
		public int compare(String s1, String s2) {
			// TODO Auto-generated method stub
			return  (s2 + s1).compareTo(s1 + s2);
		}
	
}

	
}