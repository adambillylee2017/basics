import java.util.*;

public class EvaluationDivision {
    static class Solution {
        Map<String, Set<Edge>> graph = new HashMap<>();
        double[] output;

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            output = new double[queries.size()];
            Arrays.fill(output, -1);

            // build edge graph
            for (int i = 0; i < equations.size(); i++) {
                addEdge(equations.get(i), values[i]);
            }

            for (int i = 0; i < queries.size(); i++) {
                String from = queries.get(i).get(0);
                String to = queries.get(i).get(1);
                if (!graph.containsKey(from)) {
                    output[i] = -1.0;
                } else {
                    dfs(from, to, i, 1.0, new HashSet<>());
                }
            }

            return output;
        }

        void dfs(String curr, String target, int i, double val, Set<String> visited) {
            if (curr.equals(target)) {
                output[i] = val;
                return;
            }

            if (visited.contains(curr)) {
                return;
            }
            visited.add(curr);

            if (!graph.containsKey(curr)) {
                return;
            }

            for (Edge edge : graph.get(curr)) {
                dfs(edge.to, target, i, val * edge.value, visited);
            }
        }

        void addEdge(List<String> equation, double value) {
            String first = equation.get(0);
            String second = equation.get(1);
            Edge edge = new Edge(first, second, value);
            Edge reversedE = new Edge(second, first, 1 / value);

            if (!graph.containsKey(first)) {
                graph.put(first, new HashSet<>());
            }
            if (!graph.containsKey(second)) {
                graph.put(second, new HashSet<>());
            }

            graph.get(first).add(edge);
            graph.get(second).add(reversedE);
        }

        class Edge {
            String from;
            String to;
            double value;

            public Edge(String from, String to, double value) {
                this.from = from;
                this.to = to;
                this.value = value;
            }

        }
    }
}
