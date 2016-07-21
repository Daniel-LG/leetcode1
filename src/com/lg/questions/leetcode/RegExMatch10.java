package com.lg.questions.leetcode;

public class RegExMatch10 {
	public boolean isMatch(String s, String p) {
        p = p.replaceAll("\\*+", "\\*");
        int m = s.length();
        int n = p.length();
        boolean[][] match = new boolean[m + 1][n + 1];
        match[0][0] = true;
        for (int i = 1; i <= m; i++)
            match[i][0] = false;
        for (int j = 1; j < n; j += 2) {
            if (j % 2 == 1 && p.charAt(j - 1) != '*' && p.charAt(j) == '*') {
                match[0][j] = true;
                match[0][j + 1] = true;
            }
            
            else
                break;
        }
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <=n; j++) {
                if (singleMatch(s, p, i - 1, j - 1))
                    match[i][j] = match[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*') {
                    if (j - 2 < 0)
                        return false;
                    match[i][j] = match[i][j - 2] || (match[i - 1][j] && singleMatch(s, p, i - 1, j - 2));
                }
            }
        return match[m][n];
    }
    private boolean singleMatch(String s, String p, int i, int j ) {
        if (j >= p.length() || j < 0)
            return false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
            return true;
        return false;
    }
    public static void main(String[] args) {
		RegExMatch10 r = new RegExMatch10();
		r.isMatch("a", "aa");
	}
}
