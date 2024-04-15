import java.util.HashMap;
import java.util.Map;

public class SatisfiabilityOfEqualityEquations {
    static class Solution {
        Map<Character, Character> eq = new HashMap<>();
        Map<Character, Integer> rank = new HashMap<>();

        public boolean equationsPossible(String[] equations) {
            // init eq
            for (int i=0; i<52; i++) {
                eq.put((char)('a'+i), (char)('a'+i));
                rank.put((char)('a'+i), 0);
            }

            for (String equation : equations) {
                union(equation);
            }

            for (String equation : equations) {
                char x = equation.charAt(0);
                char y = equation.charAt(3);
                char sign = equation.charAt(1);

                if (sign == '=' && find(x) != find(y)) {
                    return false;
                }

                if (sign == '!' && find(x) == find(y)) {
                    return false;
                }
            }

            return true;
        }


        char find(char c) {
            if (eq.get(c) != c) {
                eq.put(c, find(eq.get(c)));
            }

            return eq.get(c);
        }

        void union(String equations) {
            if (equations.charAt(1) == '!') {
                return;
            }

            char x = equations.charAt(0);
            char y = equations.charAt(3);
            char rX = find(x);
            char rY = find(y);

            if (rX != rY) {
                if (rank.get(rX) > rank.get(rY)) {
                    eq.put(rY, rX);
                } else if (rank.get(rX) < rank.get(rY)) {
                    eq.put(rX, rY);
                } else {
                    eq.put(rY, rX);
                    rank.put(rX, rank.get(rX) + 1);
                }
            }

        }

    }
}
