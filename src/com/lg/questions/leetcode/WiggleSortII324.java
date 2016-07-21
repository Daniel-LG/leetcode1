package com.lg.questions.leetcode;

public class WiggleSortII324 {
	 public void wiggleSort(int[] nums) {
	        //find k-th smallest element
	        int n = nums.length;
	        int median = kthLargestElement(nums, 0, n - 1, (n + 1) / 2);
	        System.out.println(median);
	        String str = "";
	        for (int i = 0; i < n; i++)
	            str += nums[i];
	        System.out.println(str);
	        int left = 0;
	        int i = 0;
	        int right = n - 1;
	        while (i <= right) {
	        	int curCheckIdx = newIdx(i, n);
	            if (nums[curCheckIdx] > median) {
	                swap(nums, newIdx(left++, n), newIdx(i++, n));
	            }
	            else if (nums[curCheckIdx] < median) {
	                swap(nums, newIdx(right--, n), newIdx(i, n));
	            }
	            else
	                i++;
	        }
	        
	    }
	    
	    private int newIdx(int old, int n) {
	        return (2 * old + 1) % (n | 1);
	    }
	    
	    //find k-th smallest element
	    private int kthLargestElement(int[] nums, int lo, int hi, int k) {

	    	int pivot = nums[hi];
	        int i = lo;
	        int left = lo;
	        for (; i < hi; i++) {
	            if (nums[i] > pivot)
	                swap(nums, i, left++);
	        }
	        swap(nums, left, hi);
	        if (left == k)
	            return nums[k];
	        else if (left < k)
	            return kthLargestElement(nums, left + 1, hi, k);
	        return kthLargestElement(nums, lo, left - 1, k);
	    }
	    
	    private void swap(int[] nums, int i, int j) {
	        int tmp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = tmp;
	    }
	    public static void main(String[] args) {
			WiggleSortII324 w = new WiggleSortII324();
			int[] nums = new int[] {1, 3, 2, 2, 3, 1};
			
			w.wiggleSort(nums);
		}
}
