package com.lg.questions.leetcode;
import java.util.*;
public class RestorIP93 {
	 public List<String> restoreIpAddresses(String s) {
	        List<String> res = new ArrayList<String>();
	        getIp(s, 4, new StringBuffer(), res);
	        System.out.println(res);
	        return res;
	    }
	    private void getIp(String s, int leftField, StringBuffer origin, List<String> res){
	        int n = s.length();
	        if (n == 0 || leftField == 0 || n < leftField)
	            return;
	        if (leftField == 1){
	            int field = Integer.valueOf(s);
	            if (field > 255)
	                return;
	            int tmp = origin.length();
	            origin.append(s);
	            res.add(origin.toString());
	            origin.delete(tmp, 16);
	            return;
	        }
	        for (int i = 1; i <= Math.min(n - leftField + 1, 3); i++){
	            String cur = s.substring(0, i);
	            if (Integer.valueOf(cur) > 255)
	            	break;
	            int tmp = origin.length();
	            origin.append(cur).append(".");
	            getIp(s.substring(i), leftField - 1, origin, res);
	            try {
	            	origin = origin.delete(tmp, 16);
				} catch (Exception e) {
					System.out.println(origin);
					System.out.println(tmp);
				}
	            
	        }
	    }
	    public static void main(String[] args) {
			RestorIP93 r = new RestorIP93();
			r.restoreIpAddresses("25525511135");
		}
}
