import java.util.HashSet;
import java.util.Set;

public class NumberOfComponentsInAnUndirectedGraph {
    static class Solution {
        int[] parents;
        // assuming 0 is the leaf, high rank means high order parents
        int[] rank;

        public int countComponents(int n, int[][] edges) {
            this.parents = new int[n];
            this.rank = new int[n];

            // init union find
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }

            // union all edges one by one
            for (int[] edge : edges) {
                int x = edge[0];
                int y = edge[1];
                union(x, y);
            }

            // count all unique parents
            Set<Integer> set = new HashSet<>();
            for (int p : parents) {
                set.add(find(p));
            }
            return set.size();
        }

        int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }

            return parents[x];
        }

        void union(int x, int y) {
            int rX = find(x);
            int rY = find(y);

            if (rank[rX] > rank[rY]) {
                parents[rY] = rX;
            } else if (rank[rY] > rank[rX]) {
                parents[rX] = rY;
            } else {
                parents[rX] = rY;
                rank[rY]++;
            }
        }
    }
}
