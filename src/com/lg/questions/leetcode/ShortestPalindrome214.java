package com.lg.questions.leetcode;

public class ShortestPalindrome214 {
	public String shortestPalindrome(String s) {
        int i = 0;
        int j = 0;
        int maxLen = 0;
        for (int mid = 0; mid <= s.length() / 2; mid++) {
            i = mid;
            j = mid;
            while (j < s.length() && s.charAt(j) == s.charAt(j + 1)) j++;
            mid = j + 1;
            while (i > 0 && j < s.length() - 1 && s.charAt(i - 1) == s.charAt(j + 1)) {
                i--;
                j++;
            }
            if (i == 0 && maxLen < j)
                maxLen = j;
        }
        StringBuilder sb = new StringBuilder(s);
        StringBuilder toAdd = new StringBuilder(s.substring(maxLen + 1));
        sb.insert(0, toAdd.reverse());
        return sb.toString();
    }
}
