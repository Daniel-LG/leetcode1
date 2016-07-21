package com.lg.questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePermutation47 {
	public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (n == 0)
            return ans;
        Arrays.sort(nums);
        permute(nums, 0, ans, new ArrayList<Integer>());
        return ans;
    }
    private void permute(int[] nums, int start, List<List<Integer>> ans, List<Integer> one){
        if (start > nums.length)
            return;
        if (start == nums.length){
            ans.add(new ArrayList(one));
            return;
        }
        for (int i = start; i < nums.length; i++){
            if (isSwap(nums, start, i)){
                swap(nums, start, i);
                one.add(nums[start]);
                permute(nums, start + 1, ans, one);
                one.remove(one.size() - 1);
                swap(nums, start, i);
            }
        }
    }
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    private boolean isSwap(int[] nums, int a, int b){
        for (int i = a; i < b; i++)
            if (nums[i] == nums[b])
                return false;
        return true;
    }
}
