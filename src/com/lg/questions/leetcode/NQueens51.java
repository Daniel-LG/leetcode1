package com.lg.questions.leetcode;
import java.util.*;
public class NQueens51 {
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList();
        int[] placed = new int[n];
        Arrays.fill(placed, -1);
        //place(0, n, placed, ans);
        place(n, (1 << n) - 1, 0, 0, 0, placed, 0, ans);
        return ans;
    }
    
    private void place(int curRow, int n, int[] placed, List<List<String>> ans) {
        if (curRow == n)
            print(placed, ans);
        else {
            for (int j = 0; j < n; j++) {
                if (canPlace(placed, curRow, j)) {
                    placed[curRow] = j;
                    place(curRow + 1, n, placed, ans);
                    placed[curRow] = -1;
                }
            }
        }
    }
    
    private void place(int n, int allPos, int row, int ld, int rd, int[] placed, int level, List<List<String>> ans) {
        if (row != allPos) {
            int pos = allPos & (~(row | ld | rd));
            while (pos != 0) {
                int place = pos & -pos;
                placed[level] = n - Integer.numberOfTrailingZeros(place) - 1;
                pos -= place;
                place(n, allPos, row + place, (ld + place) << 1, (rd + place) >> 1, placed, level + 1, ans);
            }
        }
        else {
            print(placed, ans);
        }
    }
    
    private boolean canPlace(int[] placed, int i, int j) {
        for (int row = 0; row < i; row++) {
            if (placed[row] == j || (Math.abs(i - row) == Math.abs(j - placed[row])))
                return false;
        }
        return true;
    }
    
    private void print(int[] placed, List<List<String>> ans) {
        List<String> oneAns = new ArrayList();
        for (int i = 0; i < placed.length; i++) {
            StringBuilder oneRow = new StringBuilder();
            for (int j = 0; j < placed.length; j++) {
                if (placed[i] == j)
                    oneRow.append("Q");
                else
                    oneRow.append(".");
            }
            oneAns.add(oneRow.toString());
        }
        ans.add(oneAns);
    }
    
    public static void main(String[] args) {
		NQueens51 n = new NQueens51();
		n.solveNQueens(4);
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		System.out.println(list.remove(new Integer(3)));
	}
}
