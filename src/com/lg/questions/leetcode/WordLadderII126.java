package com.lg.questions.leetcode;
import java.util.*;
public class WordLadderII126 {
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> ans = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        Map<String, List<String>> graph = new HashMap<String, List<String>>();
        constructGraph(beginWord, endWord, wordList, distance, graph);
        searchDFS(beginWord, endWord, graph, distance, new ArrayList<String>(), ans);
        return ans;
    }
    private void constructGraph(String begin, String end, Set<String> words, 
        Map<String, Integer> distance, Map<String, List<String>> graph) {
        graph.put(begin, new ArrayList<String>());
        Queue<String> queue = new ArrayDeque<String>();
        queue.offer(begin);
        distance.put(begin, 0);
        while (!queue.isEmpty()) {
            boolean foundEnd = false;
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int dist = distance.get(cur);
                List<String> neighbors = findNeighbors(cur, words);
                graph.put(cur, new ArrayList<String>(neighbors));
                for (String neighbor : neighbors) {
                    if (!distance.containsKey(neighbor)){
                        distance.put(neighbor, dist + 1);
	                    if (neighbor.equals(end))
	                        foundEnd = true;
	                    queue.offer(neighbor);
                    }
                }
            }
            if (foundEnd)
                break;
        }
    }
    private void searchDFS(String cur, String end, Map<String, List<String>> graph, 
        Map<String, Integer> distance, List<String> path, List<List<String>> paths) {
        if (graph.get(cur) == null || graph.get(cur).size() == 0)
            return;
        if (distance.get(cur) > distance.get(end))
            return;
        path.add(cur);
        if (cur.equals(end) && distance.get(cur) == distance.get(end)) {
            paths.add(new ArrayList<String>(path));
            path.remove(path.size() - 1);
            return;
        }
        
        for (String neighbor : graph.get(cur)){
            if (distance.get(neighbor) == distance.get(cur) + 1)
                searchDFS(neighbor, end, graph, distance, path, paths);
        }
        path.remove(path.size() - 1);
    }
    private List<String> findNeighbors(String begin, Set<String> words) {
        List<String> neighbors = new ArrayList<String> ();
        char[] chs = begin.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char old = chs[i];
            for (char c = 'a'; c <= 'z'; c++) {
            	if (c == old)
            		continue;
                chs[i] = c;
                if (words.contains(String.valueOf(chs)))
                    neighbors.add(String.valueOf(chs));
            }
            chs[i] = old;
        }
        return neighbors;
    }
    public static void main(String[] args) {
		WordLadderII126 w = new WordLadderII126();
		Set<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dog");
		w.findLadders("hot", "dog", set);
	}
}
