import java.util.*;

/**
 * Created by adamli on 5/8/16.
 */
public class WordLadder2 {
    static class Solution {
        List<List<String>> wordLadders;
        Map<String, Integer> distMap;

        String beginWord;

        Map<String, Set<String>> neighbours;

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            wordLadders = new ArrayList<>();
            distMap = new HashMap<>();
            neighbours = new HashMap<>();
            this.beginWord = beginWord;

            if (!wordList.contains(endWord)) {
                return wordLadders;
            }

            buildNeighbors(beginWord, endWord, wordList);

            // BFS to construct word -> distance map (from begin word)
            bfs(beginWord);

            // with the map, find all the way back with DFS and construct result
            dfs(beginWord, endWord, new ArrayList<>());

            return wordLadders;
        }

        public void buildNeighbors(String beginWord, String endWord, List<String> wordList) {
            List<String> allList = new ArrayList<>(wordList);
            allList.addAll(Arrays.asList(beginWord, endWord));

            for (int left = 0; left < allList.size() - 1; left++) {
                for (int right = 1; right < allList.size(); right++) {
                    if (connected(allList.get(left), allList.get(right))) {
                        if (!neighbours.containsKey(allList.get(left))) {
                            neighbours.put(allList.get(left), new HashSet<>());
                        }
                        if (!neighbours.containsKey(allList.get(right))) {
                            neighbours.put(allList.get(right), new HashSet<>());
                        }

                        neighbours.get(allList.get(left)).add(allList.get(right));
                        neighbours.get(allList.get(right)).add(allList.get(left));
                    }
                }
            }
        }

        public void bfs(String beginWord) {
            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            int dist = 0;

            visited.add(beginWord);
            queue.offer(beginWord);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String curr = queue.poll();

                    distMap.put(curr, dist);

                    List<String> nextWords = findNext(curr, visited);
                    queue.addAll(nextWords);
                }
                dist++;
            }
        }

        public List<String> findNext(String curr, Set<String> visited) {
            List<String> result = new ArrayList<>();

            if (neighbours.get(curr) == null) {
                return result;
            }

            for (String neighbour : neighbours.get(curr)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    result.add(neighbour);
                }
            }

            return result;
        }

        public void dfs(String curr, String endWord, List<String> currPath) {
            if (curr.equals(endWord)) {
                List<String> toBeAdded = new ArrayList<>(currPath);
                toBeAdded.add(0, beginWord);
                wordLadders.add(toBeAdded);
                return;
            }

            if (neighbours.get(curr) == null) {
                return;
            }

            for (String next : neighbours.get(curr)) {
                if (distMap.get(next) - distMap.get(curr) == 1) {
                    List<String> newPath = new ArrayList<>(currPath);
                    newPath.add(next);
                    dfs(next, endWord, newPath);
                    newPath.remove(newPath.size() - 1);
                }
            }
        }

        public boolean connected(String curr, String next) {
            if (curr.length() != next.length()) {
                return false;
            }

            int diff = 0;
            for (int i = 0; i < curr.length(); i++) {
                if (curr.charAt(i) != next.charAt(i)) {
                    diff++;
                }
            }

            return diff == 1;
        }
    }
}
