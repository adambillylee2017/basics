import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    static class Solution {
        List<String> result = new ArrayList<>();
        int n;

        public List<String> generateParenthesis(int n) {
            this.n = n;
            dfs(0, 0, new ArrayList<>());
            return this.result;
        }

        void dfs(int left, int right, List<String> path) {
            if (left > n || right > n) {
                return;
            }

            if (left == n && right == n) {
                result.add(String.join("",path));
                return;
            }

            if (left > right) {
                path.add(")");
                dfs(left, right + 1, path);
                path.remove(path.size() - 1);
            }

            path.add("(");
            dfs(left + 1, right, path);
            path.remove(path.size() - 1);
        }
    }
}
