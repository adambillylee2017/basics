import java.util.*;

public class ConcatenatedWords {
    static class Solution {
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        HashMap<String, Boolean> isConcatenatedWord = new HashMap<>();

        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            set.addAll(Arrays.asList(words));

            for (String word : words) {
                if (dfs(word)) {
                    result.add(word);
                }
            }

            return new ArrayList<>(result);
        }

        boolean dfs(String curr) {
            if (isConcatenatedWord.get(curr) != null) {
                return isConcatenatedWord.get(curr);
            }

            for (int end = curr.length(); end >= 1; end--) {
                String prefix = curr.substring(0, end);
                String suffix = curr.substring(end);

                // 1. curr is concatenation of two simple words
                if (set.contains(prefix) && set.contains(suffix)) {
                    isConcatenatedWord.put(curr, true);
                    return true;
                }

                // 2. curr is concatenated by a simple word and a concatenated word
                if (set.contains(prefix) && dfs(suffix)) {
                    isConcatenatedWord.put(curr, true);
                    return true;
                }
            }

            isConcatenatedWord.put(curr, false);
            return false;
        }

    }
}
