package com.lg.questions.leetcode;

public class ReverseWordsInString151 {
	public String reverseWords(String s) {
        String altered = s.trim();
        altered = altered.replaceAll("\\s+", " ");
        String[] strs = altered.split(" ");
        StringBuffer buffer = new StringBuffer();
        for (String str : strs) {
            buffer.insert(0, str + " ");
        }
        return buffer.toString().trim();
    }
	public static void main(String[] args) {
		ReverseWordsInString151 r = new ReverseWordsInString151();
		r.reverseWords("   a   b ");
	}
}
