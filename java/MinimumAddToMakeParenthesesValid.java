public class MinimumAddToMakeParenthesesValid {
    static class Solution {
        public int minAddToMakeValid(String s) {
            int leftParentheses = 0;
            int rightParentheses = 0;

            for (char curr : s.toCharArray()) {
                if (curr == '(') {
                    leftParentheses++;
                } else {
                    if (leftParentheses != 0) {
                        leftParentheses--;
                    } else {
                        rightParentheses++;
                    }
                }
            }

            return leftParentheses + rightParentheses;
        }
    }
}
