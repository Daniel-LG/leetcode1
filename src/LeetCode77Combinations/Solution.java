package LeetCode77Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> combine(int n,int k){
		List<List<Integer>> opt=new ArrayList<List<Integer>>();
		opt=combineHelper(n, k);
		return null;
		
	}
	private List<List<Integer>> combineHelper(int n, int k){
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		ArrayList<Integer> oneCombination=new ArrayList<Integer>();
		if(n<k)
			return null;
		if(k==0){
			ans.add(oneCombination);
			return ans;
		}
		if(n==k){
			for(int i=1;i<=n;i++)
				oneCombination.add(i);
			ans.add(oneCombination);
			return ans;
		}
		List<List<Integer>> containN=combineHelper(n-1, k-1);
		for(List<Integer> one:containN){
			one.add(n);
			ans.add(one);
		}
		List<List<Integer>> notContainN=combineHelper(n-1, k);
		for(List<Integer> tmp: notContainN)
			ans.add(tmp);
		return ans;
	}
	public static void main(String[] args) {
		Solution s=new Solution();
		s.combine(4, 2);
	}
}
