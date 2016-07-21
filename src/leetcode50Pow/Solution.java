package leetcode50Pow;

public class Solution {
	public static double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n < 0)
            x = 1 / x;
        double ans = 1;
        n = Math.abs(n);
        while(n > 0){
            if(n % 2 == 1)
                ans *= x;
            x *= x;
            n /= 2;
        }
        return ans;
    }
	public static void main(String[] args) {
		myPow(8.88, 3);
	}
}
