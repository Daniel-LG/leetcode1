package com.lg.questions.leetcode;
import java.util.*;
public class MiniWindowSubstr76 {
	public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else
                map.put(ch, 1);
        }
        int start = 0;
        char[] chs = s.toCharArray();
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = chs[i];
            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) count--;
                map.put(ch, map.get(ch) - 1);
            }
            if (count == 0) {
                while (!map.containsKey(chs[start]) || map.get(chs[start]) < 0) {
                    if (map.containsKey(chs[start]))
                        map.put(chs[start], map.get(chs[start]) + 1);
                    start++;
                }
                if (i - start + 1 < minLen) {
                    ans = s.substring(start, i + 1);
                    minLen = i - start + 1;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
		MiniWindowSubstr76 m = new MiniWindowSubstr76();
		m.minWindow("aa", "aa");
	}
}
