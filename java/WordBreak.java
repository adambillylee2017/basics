import java.util.*;

/**
 * Created by adamli on 4/2/16.
 */
public class WordBreak {
    static class Solution {
        String s;
        Set<String> dict = new HashSet<>();
        Boolean[] memo;

        public boolean wordBreak(String s, List<String> wordDict) {
            this.s = s;
            this.memo = new Boolean[s.length()];
            dict.addAll(wordDict);
            return dfs(0);
        }

        boolean dfs(int start) {
            if (start == s.length()) {
                return true;
            }

            if (memo[start] != null) {
                return memo[start];
            }

            for (int end = s.length()-1; end>= start; end--) {
                String word = s.substring(start, end + 1);
                if (dict.contains(word)) {
                    if (dfs(end + 1)) {
                        memo[start] = true;
                        return true;
                    }
                }
            }

            memo[start] = false;
            return false;
        }

    }
}
