package leetcode331;

import java.util.Stack;

public class Solution {
	public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0)
            return false;
        String[] elements = preorder.split(",");
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < elements.length - 1; i++){
        	String str = elements[i];
            if(str.equals("#")){
                if(stack.empty())
                    return false;
                stack.pop();
            }
            else
                stack.push(str);
        }
        if(!stack.empty() || !elements[elements.length - 1].equals("#"))
        	return false;
        return true;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		s.isValidSerialization("1,#");
	}
}
