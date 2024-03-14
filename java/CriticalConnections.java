import java.util.*;
import java.util.stream.Collectors;

public class CriticalConnections {

    static class Solution {
        Integer[] ranks;
        Map<Integer, List<Integer>> nodeGraph = new HashMap<>();
        Set<List<Integer>> edgeGraph;

        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            ranks = new Integer[n];

            // creating node graph to walk on
            for (int i = 0; i < n; i++) {
                nodeGraph.put(i, new ArrayList<>());
            }
            for (List<Integer> connection : connections) {
                int from = connection.get(0);
                int to = connection.get(1);
                nodeGraph.get(from).add(to);
                nodeGraph.get(to).add(from);
            }

            // build edge graph for outputting critical path
            edgeGraph = connections
                    .stream()
                    .map(connection ->
                            Arrays.asList(
                                    Math.min(connection.get(0), connection.get(1)),
                                    Math.max(connection.get(0), connection.get(1))
                            ))
                    .collect(Collectors.toSet());

            minRankInIsland(0, 0);

            // any edge on loop cannot be on critical path
            return new ArrayList<>(edgeGraph);
        }

        /**
         * if there is a loop, there min rank on the island will be rank of the first node discovered
         * @return minimum rank connected, could be rank of the current node
         */
        private int minRankInIsland(int node, int rank) {
            if (ranks[node] != null) {
                return ranks[node];
            }

            ranks[node] = rank;

            int minRankConnected = rank + 1;
            for (int neighbour : nodeGraph.get(node)) {
                Integer neighbourSteps = this.ranks[neighbour];

                if (neighbourSteps != null && neighbourSteps == rank - 1) {
                    continue;
                }

                int neighbourRank = minRankInIsland(neighbour, rank + 1);

                if (neighbourRank <= rank) {
                    // if neighbourRank <= current rank, current node is in the loop
                    // and current edge also in the loop, remove from edge graph
                    edgeGraph.remove(Arrays.asList(Math.min(node, neighbour), Math.max(node, neighbour)));
                }

                minRankConnected = Math.min(neighbourRank, minRankConnected);
            }

            return minRankConnected;
        }

    }

}
