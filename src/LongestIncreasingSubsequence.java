
public class LongestIncreasingSubsequence {
	 public static int lengthOfLIS(int[] nums) {
	        int maxLen=0;
	        int[] len=new int[nums.length];
	        for(int i=0;i<len.length;i++)
	        	len[i]=1;
	        for(int i=0;i<nums.length;i++){
	            for(int j=0;j<i;j++){
	                if(nums[j]<nums[i])
	                    len[i]=Math.max(len[i],len[j]+1);
	            }
	        }
	        for(int i=0;i<len.length;i++)
	            maxLen=Math.max(len[i],maxLen);
	        return maxLen;
	    }
	public static void main(String[] args) {
		int[] nums={1,3,6,7,9,4,10,5,6};
		int[] nums2={10,9,2,5,3,7,101,18};
		lengthOfLIS(nums2);
	}
}
