package test;



public class AllSort {
	
	public int[] getNext(String p) {
		if(p == null || p.length() == 0)
			return null;
		int i = 0;
		int j = -1;
		
		int[] next = new int[p.length()];
		next[0] = -1;
		while(i < p.length() - 1) {
			if(j == -1 || p.charAt(i) == p.charAt(j)) {
				i++;
				j++;
				next[i] = j;
			} else
				j = next[j];
		}
		return next;
	}
	public int stringPat(String s, String p) {
		if(s == null || p == null)
			return -1;
		int i = 0;
		int j = 0;
		int res = -1;
		int[] next = getNext(p);
		
		while(i < s.length()) {
			if(j == -1 || s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			} 
			else
				j = next[j];
			if( j == p.length()) {
				res = i - p.length();
				break;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[]  a = {3, 2, 1, 5, 4};
		AllSort sort = new AllSort();
		//sort.bubbleSort(a);
		//sort.selectSort(a);
		//sort.insertSort(a);
		//sort.mergeSort(a, 0, 4);
		//sort.quickSort(a, 0, 5);
		System.out.println(sort.stringPat("aaab", "ab"));
//		for (int tmp: a) {
//			System.out.println(tmp);
//		}
		
	}
}
