package com.lg.questions.leetcode;

public class PermutationSeq60 {
	public String getPermutation(int n, int k) {
        int[] num = new int[n];
        for (int i = 0; i < n; i++)
            num[i] = i + 1;
        for (int i = 0; i < k; i++)
            getNextPermutation(num);
        StringBuffer buffer = new StringBuffer();
        for (int i : num)
            buffer.append(i);
        return buffer.toString();
    }
    private void getNextPermutation(int[] num){
        int n = num.length;
        int firstDown = n - 1;
        for (; firstDown >= 1; firstDown--)
            if (num[firstDown] > num[firstDown - 1])
                break;
        firstDown--;
        int littleLarger = n - 1;
        while (littleLarger > firstDown && num[littleLarger] <= num[firstDown])
            littleLarger--;
        swap(num, firstDown, littleLarger);
        pivot(num, firstDown + 1, n - 1);
    }
    private void swap(int[] num, int a, int b){
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }
    private void pivot(int[] num, int a, int b){
        while (a < b)
            swap(num, a++, b--);
    }
    public static void main(String[] args) {
		PermutationSeq60 p = new PermutationSeq60();
		p.getPermutation(3, 4);
	}
}
