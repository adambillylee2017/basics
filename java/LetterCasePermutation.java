import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    static class Solution {
        String s;
        List<String> result = new ArrayList<>();

        public List<String> letterCasePermutation(String s) {
            this.s = s;
            dfs(0, new StringBuilder());
            return this.result;
        }

        public void dfs(int start, StringBuilder sb) {
            if (start == s.length()) {
                result.add(sb.toString());
                return;
            }

            char c = s.charAt(start);

            if (Character.isDigit(c)) {
                sb.append(c);
                dfs(start + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                char lower = Character.toLowerCase(c);
                char upper = Character.toUpperCase(c);

                sb.append(lower);
                dfs(start + 1, sb);
                sb.deleteCharAt(sb.length() - 1);

                sb.append(upper);
                dfs(start + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
