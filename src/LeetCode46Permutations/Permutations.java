package LeetCode46Permutations;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Permutations {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String strNums=scanner.nextLine();
		List<String> list=Arrays.asList(strNums.split(","));
		int[] nums=new int[list.size()];
		for(int i=0;i<nums.length;i++){
			nums[i]=Integer.parseInt(list.get(i));
		}
		Arrays.sort(nums);
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		putRes(nums,res);
		notRecursive(nums,res);
	}

	private static void putRes(int[] nums, List<List<Integer>> res) {
		List<Integer>tmp=new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++)
			tmp.add(nums[i]);
		res.add(tmp);
	}

	private static void notRecursive(int[] nums, List<List<Integer>> res) {
		int n=nums.length;
		boolean flag=true;
		while(flag){
//			int[] tmp=new int[n];
//			recordLastNums(tmp,nums);
			int j=n-1;
			while(j>=1&&nums[j]<nums[j-1])j--;	//从后往前找第一个j－1使得nums[j-1]<nums[j];
			j=j-1;	//j指向转向的那个元素
			if(j==0)	//如果j＝＝0说明整个数组是递减的，说明已经得出了最后一个全排列
				break;
			int k=j+1;	//k从j开始向后找，找到下标最大的元素，这个元素满足nums[k]>nums[j]
			while(k<n&&nums[k]>nums[j])k++;
			k=k-1;
			swap(nums,j,k);	//交换j，k指向的元素
			revert(nums,j+1,n-1);	//颠倒j之后到结尾的元素，就是上一个排列根据字典序的下一个排列
			putRes(nums, res);
//			if(nums.equals(res))
//				flag=false;
		}
	}

	

	private static void recordLastNums(int[] tmp, int[] nums) {
		for(int i=0;i<nums.length;i++)
			tmp[i]=nums[i];
	}

	private static void revert(int[] nums, int i, int j) {
		for(int k=0;k<(j-i)/2+1;k++){
			swap(nums, i+k, j-k);
		}
	}

	private static void swap(int[] nums, int j, int k) {
		int tmp=nums[j];
		nums[j]=nums[k];
		nums[k]=tmp;
	}
}
