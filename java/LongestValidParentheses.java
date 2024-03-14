import java.util.*;

public class LongestValidParentheses {
    static class Solution {
        Stack<Integer> openingIndexes = new Stack<>();
        int[] longestEndsHere;

        public int longestValidParentheses(String s) {
            int max = 0;
            longestEndsHere = new int[s.length()];

            for (int curr = 0; curr < s.length(); curr++) {
                if (s.charAt(curr) == '(') {
                    openingIndexes.push(curr);
                } else {
                    if (!openingIndexes.isEmpty()) {
                        int openIndex = openingIndexes.pop();
                        int lengthSinceOpenIndex = curr - openIndex + 1;

                        int len = lengthSinceOpenIndex + getLongestEndsHere(openIndex - 1);

                        max = Math.max(len, max);
                        longestEndsHere[curr] = Math.max(len, longestEndsHere[curr]);
                    }
                }
            }

            return max;
        }

        public int getLongestEndsHere(int end) {
            if (end == -1) {
                return 0;
            } else {
                return longestEndsHere[end];
            }
        }

    }

}
