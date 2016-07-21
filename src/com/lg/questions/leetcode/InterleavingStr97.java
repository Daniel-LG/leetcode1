package com.lg.questions.leetcode;

public class InterleavingStr97 {
	public boolean isInterleave(String s1, String s2, String s3) {
        //return helper(s1, s2, s3, 0, 0, 0);
		
		boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
		dp[0][0] = true;
		for (int i = 1; i < s1.length() + 1; i++) 
			dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
		for (int j = 1; j < s2.length() + 1; j++)
			dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
		for (int i = 1; i < s1.length() + 1; i++)
			for (int j = 1; j < s2.length() + 1; j++) {
				dp[i][j] = ((dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
							|| (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)));
				
			}
		return dp[s1.length()][s2.length()];
    }
    /*private boolean helper(String s1, String s2, String s3, int i, int j, int k) {
        if (i == s1.length() && j == s2.length() && k == s3.length())
            return true;
        if (i == s1.length())
            return s2.substring(j).equals(s3.substring(k));
        if (j == s2.length())
            return s1.substring(i).equals(s3.substring(k));
        boolean ret = false;
        if (s1.charAt(i) == s3.charAt(k))
            ret = helper(s1, s2, s3, i + 1, j , k + 1);
        if (!ret && s2.charAt(j) == s3.charAt(k))
            ret |= helper(s1, s2, s3, i, j + 1, k + 1);
        if (s1.charAt(i) != s3.charAt(k) && s2.charAt(j) != s3.charAt(k))
            return false;
        return ret;
    }*/
    public static void main(String[] args) {
    	InterleavingStr97 i = new InterleavingStr97();
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		i.isInterleave(s1, s2, s3);
	}
}
