package test;


public class KMP {
	public int[] getNext(String p) {
		if(p == null || p.length() == 0)
			return null;
		int[] next = new int[p.length()];
		int i = 0;
		int j = -1;
		next[0] = -1;
		while(i < p.length() - 1) {
			if(j == -1 || p.charAt(i) == p.charAt(j)) {
				i++;
				j++;
				if(p.charAt(i) == p.charAt(j))
					next[i] = next[j];
				else
					next[i] = j;
			} else {
				j = next[j];
			}
		}
		return next;
	}
	
	public int KMP1(String s, String p) {
		if(s == null || p == null)
			return -1;
		int[] next = getNext(p);
		int res = -1;
		int i = 0;
		int j = 0;
		while(i < s.length()) {
			if(j == -1 || s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
			if(j == p.length()) {
				res = i - p.length();
				break;
			}
			
		}
		return res;
	}
	public static void main(String[] arg) {
		KMP kmp = new KMP();
		System.out.println(kmp.KMP1("abcd", "abcdef"));
	}
}
