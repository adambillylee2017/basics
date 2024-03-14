import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {
    static class Solution {
        public List<Integer> diffWaysToCompute(String exp) {
            return dfs(exp);
        }

        List<Integer> dfs(String exp) {
            List<Integer> path = new ArrayList<>();

            for (int i = 0; i < exp.length(); i++) {
                char c = exp.charAt(i);

                if (!Character.isDigit(c)) {
                    List<Integer> left = dfs(exp.substring(0, i));
                    List<Integer> right = dfs(exp.substring(i + 1));
                    merge(left, right, c, path);
                }
            }

            // base case
            if (path.isEmpty())
                path.add(Integer.valueOf(exp));
            return path;
        }

        private void merge(List<Integer> left,
                           List<Integer> right,
                           char c,
                           List<Integer> path) {
            for (int l : left) {
                for (int r : right) {
                    switch (c) {
                        case '-':
                            path.add(l - r);
                            break;
                        case '+':
                            path.add(l + r);
                            break;
                        case '*':
                            path.add(l * r);
                            break;
                    }
                }
            }
        }
    }

}