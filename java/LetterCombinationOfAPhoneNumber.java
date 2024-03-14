import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfAPhoneNumber {
    static class Solution {

        Map<Character, String> lookup = Map.of(
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz"
        );
        List<String> result = new ArrayList<>();
        String digits;

        public List<String> letterCombinations(String digits) {
            this.digits = digits;

            dfs(0, new ArrayList<>());

            return result;
        }

        void dfs(int start, List<String> path) {
            if (start == digits.length()) {
                if (path.size()>0) {
                    result.add(String.join("", path));
                }
                return;
            }

            String s = lookup.get(digits.charAt(start));
            for (int i = 0; i < s.length(); i++) {
                path.add(s.substring(i, i+1));
                dfs(start + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
