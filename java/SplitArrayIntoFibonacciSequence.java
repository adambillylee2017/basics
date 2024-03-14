import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {
    static class Solution {
        List<Integer> seqs;
        String num;

        public List<Integer> splitIntoFibonacci(String num) {
            this.seqs = new ArrayList<>();
            this.num = num;

            dfs(0, new ArrayList<>());
            return seqs;
        }

        public void dfs(int start, List<Integer> path) {
            if (start == num.length() && path.size() >= 3) {
                this.seqs = new ArrayList<>(path);
            }

            for (int end = start; end < num.length(); end++) {
                if (isFib(num.substring(start, end + 1), path)) {
                    int curr = Integer.parseInt(num.substring(start, end + 1));
                    path.add(curr);
                    dfs(end + 1, path);
                    path.remove(path.size() - 1);
                }
            }
        }

        public boolean isFib(String s, List<Integer> path) {
            if (s.charAt(0) == '0' && s.length() > 1) {
                return false;
            }

            int curr = 0;
            try {
                curr = Integer.parseInt(s);
            }
            catch(Exception e) {
                return false;
            }

            if (path.size() < 2) {
                return true;
            } else {
                return curr == path.get(path.size() - 1) + path.get(path.size() - 2);
            }
        }

    }
}
