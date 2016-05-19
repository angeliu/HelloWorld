package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combine {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if ((n + m) % 2 == 0)
        	return (getMedian(nums1, n, nums2, m, (n + m)/2) + getMedian(nums1, n, nums2, m, (n + m)/2 + 1))/2.0;
        else
        	 return getMedian(nums1, n, nums2, m, (m + n)/2 + 1);
       
    }
	public int getMedian(int[] nums1, int n, int[] nums2, int m, int k) {
		if (n <= 0) return nums2[k - 1];
		if (m <= 0) return nums1[k - 1];
		if (k <= 1) return Math.min(nums1[0], nums2[0]);
		if (nums1[n/2] >= nums2[m/2]) {
			if ((n/2 + m/2 + 1) >= k)
				return getMedian(nums1, n/2, nums2, m, k);
			else
				return getMedian(nums1, n, Arrays.copyOfRange(nums2, m/2 + 1, m), m - m/2 -1, k - n/2 -1);
		} else {
			if ((n/2 + 1 + m/2) >= k)
				return getMedian(nums1, n, nums2, m/2, k);
			else
				return getMedian(Arrays.copyOfRange(nums1, n/2 + 1, n), n - n/2 - 1, nums2, m, k - n/2 - 1);
		}
	}
	List<List<Integer>> res;
	List<Integer> solu;
	public List<List<Integer>> combine(int n, int k) {
	       res = new ArrayList<>();
	       solu = new ArrayList<>();
	       getCombine(n, k, 1);
	       return res;
	}
	public void getCombine(int n, int k, int st) {
		if (solu.size() == k) {
			res.add(new ArrayList<>(solu));
			return ;
		}
		for (int i = st; i <= n; i++) {
			solu.add(i);
			getCombine(n, k, i + 1);
			solu.remove(solu.size() - 1);
		}
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        solu = new ArrayList<>();
        Arrays.sort(candidates);
        getCombination(candidates, target, 0, 0);
        	return res;
        
    }
	public void getCombination (int[] candidates, int target, int sum, int level) {
		if (sum > target)
			return ;
		if (sum == target) {
			res.add(new ArrayList<>(solu));
			return ;
		}
		
		for (int i = level; i < candidates.length; i++) {
			sum += candidates[i];
			solu.add(candidates[i]);
			getCombination(candidates, target, sum, i + 1);
			solu.remove(solu.size() - 1);
			sum -= candidates[i];
			while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) i++;
		}
	}
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		 res = new ArrayList<>();
	     solu = new ArrayList<>();
	     Arrays.sort(candidates);
	     getCombination(candidates, target, 0, 0);
	     return res; 
	}
	public  static void main(String[] args) {
		Combine com = new Combine();
		
	}
}
