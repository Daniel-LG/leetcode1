package com.lg.questions.leetcode;

public class ScrambleStr87 {
	public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        int[] count = new int[26];
        int len = s1.length();
        for (int i = 0; i < len; i++){
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) 
            if (count[i] != 0)
                return false;
        for (int i = 1; i < len; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && 
                isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(len - i)) && 
                isScramble(s1.substring(i), s2.substring(0, len - i)))
                return true;
        }
        return false;
    }
	public static void main(String[] args) {
		ScrambleStr87 s = new ScrambleStr87();
		s.isScramble("ab", "ba");
	}
}
