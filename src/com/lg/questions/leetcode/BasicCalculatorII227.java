package com.lg.questions.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BasicCalculatorII227 {
    public int calculate(String s) {
        if (s.length() == 0)
            return 0;
        Deque<String> post = new ArrayDeque<String>();
        in2post(s, post);
        return calculateFromPost(post);
    }
    private void in2post(String s, Deque<String> post){
        if (s.length() < 1)
            return;
        char[] in = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < in.length; i++){
            char cur = in[i];
            if (cur == ' ')
                continue;
            String num = "";
            while (isNum(cur) ){
                num += String.valueOf(cur);
                if (i >= in.length - 1)
                    break;
                cur = in[++i];
            }
            if (num != ""){
                if (!isNum(cur))
                    i--;
                post.offer(num);
                continue;
            }
            while (!stack.isEmpty()){
                char top = stack.peek();
                if (priority(cur, top) > 0){
                    post.offer(String.valueOf(top));
                    stack.pop();
                }
                else
                    break;
            }
            stack.push(cur);
        }
        while (!stack.isEmpty())
            post.offer(String.valueOf( (stack.pop()) ) );
    }
    private boolean isNum(char ch){
        if (ch >= '0' && ch <= '9')
            return true;
        return false;
    }
    private int priority (char cur, char top){
        if (cur == '+' || cur == '-')
            return 1;
        if ((cur == '*' || cur == '/') && (top == '*' || top == '/'))
            return 1;
        return -1;
    }
    private int calculateFromPost(Deque<String> post){
        Stack<Integer> nums = new Stack<Integer>();
        while (!post.isEmpty()){
            String str = post.poll();
            if (isNum(str)){
                nums.push(Integer.valueOf(str));
                continue;
            }
            int right = nums.pop();
            int left = nums.pop();
            switch (str){
                case "+" : nums.push(left + right);
                    break;
                case "-" : nums.push(left - right);
                    break;
                case "*" : nums.push(left * right);
                    break;
                case "/" : nums.push(left / right);
            }
        }
        return nums.pop();
    }
    private boolean isNum(String str){
        return str.matches("\\d+");
    }
    public static void main(String[] args) {
		BasicCalculatorII227 b = new BasicCalculatorII227();
		b.calculate(" 3+5 / 2 ");
	}
}
