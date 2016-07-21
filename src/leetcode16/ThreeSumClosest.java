package leetcode16;
import java.util.Arrays;
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        if (n < 3){
            for (int i : nums)
                sum += i;
            return sum;
        }
        Arrays.sort(nums);
        sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; i++){
            int j = i + 1;
            int k = n - 1;
            while (j < k){
                int curSum = nums[i] + nums[j] + nums[k];
                if (Math.abs(curSum - target) < Math.abs(sum - target)){
                    sum = curSum;
                    if (sum == target)
                        return sum;
                }
                if (curSum < target)
                    j++;
                else
                    k--;
            }
        }
        return sum;
    }
	public static void main(String[] args) {
		ThreeSumClosest t = new ThreeSumClosest();
		int[] nums = new int[]{1,2,4,8,16,32,64,128};
		t.threeSumClosest(nums, 82);
	}
}
