import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    static class Solution {
        Map<Character, Character> map =
                Map.of(
                        '(', ')',
                        '{', '}',
                        '[', ']');
        Stack<Character> parenthesesOpened = new Stack<>();

        public boolean isValid(String s) {
            for (char c : s.toCharArray()) {
                if (isOpenHere(c)) {
                    parenthesesOpened.push(c);
                } else if (canCloseHere(c)) {
                    parenthesesOpened.pop();
                } else {
                    return false;
                }
            }

            return parenthesesOpened.isEmpty();
        }

        boolean isOpenHere(char c) {
            return map.containsKey(c);
        }

        boolean canCloseHere(char close) {
            if (parenthesesOpened.isEmpty()) {
                return false;
            }

            char lastOpen = parenthesesOpened.peek();
            return map.get(lastOpen) == close;
        }
    }
}
