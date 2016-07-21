package leetcode330;

public class PatchArray {
	public int minPatches(int[] nums, int n) {
        int missed = 1;
        int count = 0;
        int i = 0;
        while (missed <= n && missed > 0){
            if (i < nums.length && nums[i] <= missed){
                missed += nums[i];
                i++;
            }
            else{
                missed += missed;
                count++;
            }
        }
        return count;
    }
	public static void main(String[] args) {
		PatchArray p = new PatchArray();
		int[] num = new int[]{1, 3, 31, 33};
		p.minPatches(num, 2147483647);
	}
}
