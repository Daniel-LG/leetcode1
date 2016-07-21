package com.lg.questions.leetcode;

public class FirstMissingPositive41 {
	public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int miss = 0;
        for (int i = 0; i < n; i++) {
            int rightPos = nums[i] - 1;
            while (rightPos >= 0 && rightPos < n && nums[rightPos] != nums[i]) {
                swap(nums, rightPos, i);
                rightPos = nums[i] - 1;
            }
        }
        for (int i = 0; i < n; i++)
            if (nums[i] != i + 1)
                return i + 1;
        return n + 1;
    }
    private void swap(int[] nums, int i , int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String[] args) {
		FirstMissingPositive41 f = new FirstMissingPositive41();
		f.firstMissingPositive(new int[]{0,1,2});
	}
}
