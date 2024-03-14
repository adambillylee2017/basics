import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class ExpressionAddOperators {
    static class Solution {
        List<String> exps;
        int target;

        public List<String> addOperators(String num, int target) {
            this.exps = new ArrayList<>();
            this.target = target;

            dfs(num, new Stack<>(), new Stack<>(), new StringBuilder());
            return this.exps;
        }

        private void dfs(String num, Stack<Long> numsOnPath, Stack<Character> opsOnPath, StringBuilder sb) {
            if (num.isEmpty()) {
                if (compute(numsOnPath, opsOnPath) == target) {
                    exps.add(sb.toString());
                }
                return;
            }

            int sblength = sb.length();
            for (int i = 0; i < num.length(); i++) {
                String cut = num.substring(0, i + 1);
                String left = num.substring(i + 1);

                if (isValid(cut)) {
                    long tmp = Long.parseLong(cut);

                    if (numsOnPath.isEmpty()) {
                        numsOnPath.push(tmp);
                        sb.append(tmp);
                        dfs(left, numsOnPath, opsOnPath, sb);
                        numsOnPath.remove(numsOnPath.size() - 1);
                        sb.delete(sblength, sb.length());
                        continue;
                    }

                    numsOnPath.add(tmp);
                    opsOnPath.add('+');
                    sb.append('+');
                    sb.append(tmp);
                    dfs(left, numsOnPath, opsOnPath, sb);
                    numsOnPath.remove(numsOnPath.size() - 1);
                    opsOnPath.remove(opsOnPath.size() - 1);
                    sb.delete(sblength, sb.length());

                    numsOnPath.add(tmp);
                    opsOnPath.add('-');
                    sb.append('-');
                    sb.append(tmp);
                    dfs(left, numsOnPath, opsOnPath, sb);
                    numsOnPath.remove(numsOnPath.size() - 1);
                    opsOnPath.remove(opsOnPath.size() - 1);
                    sb.delete(sblength, sb.length());

                    numsOnPath.add(tmp);
                    opsOnPath.add('*');
                    sb.append('*');
                    sb.append(tmp);
                    dfs(left, numsOnPath, opsOnPath, sb);
                    numsOnPath.remove(numsOnPath.size() - 1);
                    opsOnPath.remove(opsOnPath.size() - 1);
                    sb.delete(sblength, sb.length());
                }
            }
        }

        private boolean isValid(String cut) {
            if (cut.length() > 1) {
                return cut.charAt(0) != '0';
            }

            return true;
        }

        public long compute(List<Long> numbers, List<Character> ops) {
            Stack<Long> ns1 = new Stack<>();
            Stack<Character> os1 = new Stack<>();
            for (int i = numbers.size() - 1; i >= 0; i--)
                ns1.add(numbers.get(i));
            for (int i = ops.size() - 1; i >= 0; i--)
                os1.add(ops.get(i));

            Stack<Long> ns2 = new Stack<>();
            Stack<Character> os2 = new Stack<>();

            // deal with all the '*'s
            while (!os1.isEmpty()) {
                char op = os1.pop();
                if (op != '*') {
                    ns2.push(ns1.pop());
                    os2.push(op);
                } else {
                    long right = ns1.pop();
                    long left = ns1.pop();
                    ns1.push(left * right);
                }
            }

            // recover
            while (!ns2.isEmpty()) {
                ns1.push(ns2.pop());
            }
            while (!os2.isEmpty()) {
                os1.push(os2.pop());
            }

            // deal with '+' and '-'
            while (!os1.empty()) {
                char op = os1.pop();
                long left = ns1.pop();
                long right = ns1.pop();

                if (op == '+') {
                    ns1.push(left + right);
                }

                if (op == '-') {
                    ns1.push(left - right);
                }
            }

            return ns1.pop();
        }

    }

}
