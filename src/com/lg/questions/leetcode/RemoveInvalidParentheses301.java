package com.lg.questions.leetcode;
import java.util.*;
public class RemoveInvalidParentheses301 {
	public List<String> removeInvalidParentheses(String s) {
        return BFS(s);
    }
    private List<String> BFS(String s) {
        List<String> ans = new ArrayList<String>();
        Queue<String> queue = new ArrayDeque<String>();
        Set<String> visited = new HashSet<String>();
        queue.offer(s);
        visited.add(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (isValid(cur)) {
                ans.add(cur);
                found = true;
            }
            if (found)
            	continue;
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) != '(' && cur.charAt(i) != ')') continue;
                String next = cur.substring(0, i) + cur.substring(i + 1);
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        return ans;
    }
    private boolean isValid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') count++;
            if (str.charAt(i) == ')') count--;
            if (count < 0)
                return false;
        }
        return count == 0;
    }
    public static void main(String[] args) {
		RemoveInvalidParentheses301 r = new RemoveInvalidParentheses301();
		r.removeInvalidParentheses("()())()");
	}
}
