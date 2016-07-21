package com.lg.questions.leetcode;

public class PrefectSquare367 {
	public boolean isPerfectSquare(int num) {
        if (num <= 0)
            return false;
        int lo = 1;
        int hi = num;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            long t =(long) mid * mid;
            if ( t == num)
                return true;
            if ( t < num)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return false;
    }
	public static void main(String[] args) {
		PrefectSquare367 p = new PrefectSquare367();
		p.isPerfectSquare(Integer.MAX_VALUE);
		long ans = (long)(Integer.MAX_VALUE / 2) * (Integer.MAX_VALUE / 2);
		System.out.println(ans);
	}
}
