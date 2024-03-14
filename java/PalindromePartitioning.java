import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 4/18/16.
 */
public class PalindromePartitioning {
    static class Solution {
        String s;
        List<List<String>> solutions = new ArrayList<>();
        Boolean[][] isPalindrome;

        public List<List<String>> partition(String s) {
            this.s = s;
            this.isPalindrome = new Boolean[s.length()][s.length()];

            dfs(0, new ArrayList<>());
            return solutions;
        }

        void dfs(int start, List<String> solution) {
            if (start == s.length()) {
                solutions.add(new ArrayList<>(solution));
                return;
            }

            for (int end = start; end < s.length(); end++) {
                if (isPalindrome(s, start, end)) {
                    String curr = s.substring(start, end + 1);
                    solution.add(curr);
                    dfs(end + 1, solution);
                    solution.remove(solution.size() - 1);
                }
            }
        }

        boolean isPalindrome(String s, int l, int r) {
            if (isPalindrome[l][r] != null) {
                return isPalindrome[l][r];
            }

            while (r > l) {
                if (s.charAt(l) == s.charAt(r)) {
                    l++;
                    r--;
                } else {
                    isPalindrome[l][r] = false;
                    return false;
                }
            }

            isPalindrome[l][r] = true;
            return true;
        }
    }
}
