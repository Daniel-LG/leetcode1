package com.lg.questions.leetcode;

import java.util.Scanner;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class WordSearch79 {
	public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0)
            return false;
        int n = board[0].length;
        if (n == 0 || m * n < word.length())
            return false;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++){
                if (board[i][j] == word.charAt(0)){
                    if (search(board, visited, m, n, i, j, 0, word))
                        return true;
                }
            }
        return false;
    }
    private boolean search(char[][] board, boolean[][] visited, int m, int n, int i, int j, int start, String word){
        if (start == word.length())
            return true;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(start))
            return false;
        visited[i][j] = true;
        boolean up = search(board, visited, m, n, i - 1, j, start + 1, word);
        boolean down = search(board, visited, m, n, i + 1, j, start + 1, word);
        boolean left = search(board, visited, m, n, i, j - 1, start + 1, word);
        boolean right = search(board, visited, m, n, i, j + 1, start + 1, word);
        visited[i][j] = false;
        return up || down || left || right;
    }
    public static void main(String[] args) {
		char[][] board = new char[][]{{'a', 'b', 'c','e'},
									  {'s', 'f', 'c', 's'},
									  {'a', 'd', 'e', 'e'}};
		WordSearch79 w = new WordSearch79();
		w.exist(board, "see");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		String s = sc.nextLine();
		System.out.println((a + b + c) + " " + s);
		sc.close();
	}
    
}
