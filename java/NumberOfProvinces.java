import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfProvinces {
    static class Solution {
        int[][] isConnected;
        boolean[] visited;
        Map<Integer, Set<Integer>> map;

        public int findCircleNum(int[][] isConnected) {
            this.isConnected = isConnected;
            visited = new boolean[isConnected.length];
            map = new HashMap<>();

            for (int from = 0; from < isConnected.length; from++) {
                if (!map.containsKey(from)) {
                    map.put(from, new HashSet<>());
                }
                for (int to = 0; to < isConnected.length; to++) {
                    if (from != to && isConnected[from][to] == 1) {
                        map.get(from).add(to);
                    }
                }
            }

            int provinces = 0;
            for (int from = 0; from < isConnected.length; from++) {
                if (!visited[from]) {
                    dfs(from);
                    provinces++;
                }
            }

            return provinces;
        }

        private void dfs(int from) {
            if (visited[from]) {
                return;
            }

            visited[from] = true;
            for (int to : map.get(from)) {
                dfs(to);
            }
        }

    }
}
