package com.lg.questions.leetcode;
import java.util.*;
public class WordSearchII212 {
	class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<String>();
        if (board.length == 0)
            return ans;
        TrieNode root = new TrieNode();
        buildTrieTree(words, root);
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                find(board, root, i, j, ans);
        return ans;
    }
    private void find(char[][] board, TrieNode p, int i, int j, List<String> ans) {
        char tmp = board[i][j];
        int idx = tmp - 'a';
        if (tmp == '*' || p.next[idx] == null)
            return;
        p = p.next[idx];
        if (p.word != null) {
            ans.add(p.word);
            p.word = null;
        }
        board[i][j] = '*';
        if (i > 0) find(board, p, i - 1, j, ans);
        if (i < board.length - 1) find(board, p, i + 1, j, ans);
        if (j > 0) find(board, p, i, j - 1, ans);
        if (j < board[0].length - 1) find(board, p, i, j + 1, ans);
        board[i][j] = tmp;
        
    }
    private void buildTrieTree(String[] words, TrieNode root) {
        TrieNode p = root;
        for (String word : words) {
            char[] chs = word.toCharArray();
            for (char c : chs) {
                int idx = c - 'a';
                if (p.next[idx] == null)
                    p.next[idx] = new TrieNode();
                p = p.next[idx];
            }
            p.word = word;
            p = root;
        }
    }
    public static void main(String[] args) {
		WordSearchII212 w = new WordSearchII212();
		char[][] board = new char[][]{
		                               {'o','a','a','n'},
		                               {'e','t','a','e'},
		                               {'i','h','k','r'},
		                               {'i','f','l','v'},
		                             };   
		String[] words = new String[]{"oath","pea","eat","rain"};

		w.findWords(board, words);
	}
}
