import java.util.*;

public class WorkBreakII {
    static class Solution {
        String s;
        Set<String> dict = new HashSet<>();
        List<String> solutions;

        public List<String> wordBreak(String s, List<String> wordDict) {
            this.s = s;
            this.solutions = new ArrayList<>();
            dict.addAll(wordDict);
            dfs(0, new ArrayList<>());

            return solutions;
        }

        void dfs(int start, List<String> path) {
            if (start == s.length()) {
                solutions.add(String.join(" ",path));
                return;
            }

            for (int end = s.length()-1; end>= start; end--) {
                String word = s.substring(start, end + 1);
                if (dict.contains(word)) {
                    path.add(word);
                    dfs(end+1, path);
                    path.remove(path.size()-1);
                }
            }
        }
    }
}
