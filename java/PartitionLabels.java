import java.util.*;
import java.util.stream.Collectors;

public class PartitionLabels {
    static class Solution {
        String s;
        List<Integer> solution;
        Map<Character, Integer> freq;

        public List<Integer> partitionLabels(String s) {
            this.s = s;
            this.solution = new ArrayList<>();

            this.freq = new HashMap<>();
            for (char c : s.toCharArray()) {
                plusOne(freq, c);
            }

            dfs(0, new ArrayList<>());
            return solution;
        }

        public boolean dfs(int start, List<Integer> cuts) {
            if (start == s.length()) {
                if (freq.isEmpty()) {
                    solution = cuts;
                    return true;
                }
            }

            for (int end = start; end < s.length(); end++) {
                String tmp = s.substring(start, end + 1);
                Map<Character, Integer> freqBeforeStrRemoval =
                        copyMap();

                if (removeString(tmp, freq)) {
                    cuts.add(end - start + 1);
                    if (dfs(end + 1, cuts)) {
                        return true;
                    }
                    freq = freqBeforeStrRemoval;
                    cuts.remove(cuts.size() - 1);
                }
            }

            return false;
        }

        public Map<Character, Integer> copyMap() {
            Map<Character, Integer> result = new HashMap<>();
            for (Character key : freq.keySet()) {
                result.put(key, freq.get(key));
            }
            return result;
        }


        public boolean removeString(String s, Map<Character, Integer> freq) {
            for (char c : s.toCharArray()) {
                if (freq.containsKey(c)) {
                    minusOne(freq, c);
                } else {
                    return false;
                }
            }

            return true;
        }

        public void plusOne(Map<Character, Integer> freq, char c) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        public void minusOne(Map<Character, Integer> freq, char c) {
            freq.put(c, freq.get(c) - 1);

            if (freq.get(c) == 0) {
                freq.remove(c);
            }
        }
    }
}
