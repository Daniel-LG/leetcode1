package com.lg.questions.leetcode;
import java.util.*;
public class LongesSubstrWithoutRepeat3 {
	public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int i = 0;
        int j = 0;
        Map<Character, Integer> occured = new HashMap<Character, Integer>();
        while (j < s.length()){
            char curCh = s.charAt(j);
            if (occured.containsKey(curCh)){
                len = Math.max(len, j - i);
                int idx = occured.get(curCh);
                while (i <= idx)
                    occured.remove(s.charAt(i++));
            }
            occured.put(curCh, j);
            j++;
        }
        return len;
    }
	public static void main(String[] args) {
		LongesSubstrWithoutRepeat3 l = new LongesSubstrWithoutRepeat3();
		l.lengthOfLongestSubstring("abcabcbb");
	}
}
