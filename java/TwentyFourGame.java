import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class TwentyFourGame {
    static class Solution {
        double[] dCards;
        double target = 24;
        List<Double> path = new ArrayList<>();


        public boolean judgePoint24(int[] cards) {
            dCards = Arrays.stream(cards).mapToDouble(card -> card + 0.0).toArray();
            return dfs(new boolean[cards.length]);
        }

        boolean dfs(boolean[] visited) {
            if (path.size() == dCards.length) {
                return partition(0, path.size()-1).contains(target);
            }

            for (int i = 0; i < dCards.length; i++) {
                if (visited[i]) {
                    continue;
                }

                double curr = dCards[i];
                visited[i] = true;
                path.add(curr);
                if(dfs(visited)){
                    return true;
                }
                visited[i] = false;
                path.remove(path.size() - 1);
            }

            return false;
        }

        List<Double> partition(int start, int end) {
            List<Double> result = new ArrayList<>();

            if(start == end) {
                return Arrays.asList(path.get(start));
            }

            for (int i=start; i<end; i++) {
                List<Double> left = partition(start,i);
                List<Double> right = partition(i+1, end);

                result.addAll(merge(left, right));
            }

            return result;
        }

        List<Double> merge(List<Double> left, List<Double> right) {
            List<Double> result = new ArrayList<>();

            for (double l : left) {
                for (double r: right) {
                    for (BiFunction<Double, Double,Double> function : getFunctions()) {
                        double tmp = function.apply(l, r);

                        if (Math.abs(tmp-24) < 0.001) {
                            result.add(24.0);
                        } else {
                            result.add(tmp);
                        }
                    }
                }
            }

            return result;
        }

        List<BiFunction<Double, Double, Double>> getFunctions() {
            return Arrays.asList(
                    (a,b) -> a+b,
                    (a,b) -> a*b,
                    (a,b) -> a-b,
                    (a,b) -> b-a,
                    (a,b) -> a/b,
                    (a,b) -> b/a
            );
        }
    }
}
