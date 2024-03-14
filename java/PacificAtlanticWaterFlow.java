import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    static class Solution {
        int[][] heights;
        int tc;
        int tr;
        boolean[][] pacificVisited;
        boolean[][] atlanticVisited;
        List<List<Integer>> result = new ArrayList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            // init
            this.heights = heights;
            tr = heights.length;
            tc = heights[0].length;
            pacificVisited = new boolean[tr][tc];
            atlanticVisited = new boolean[tr][tc];

            for (int r = 0; r < tr; r++) {
                dfs(r, 0, pacificVisited, Integer.MIN_VALUE);
                dfs(r, tc - 1, atlanticVisited, Integer.MIN_VALUE);
            }

            for (int c = 0; c < tc; c++) {
                dfs(0, c, pacificVisited, Integer.MIN_VALUE);
                dfs(tr - 1, c, atlanticVisited, Integer.MIN_VALUE);
            }

            for (int r=0; r<tr; r++) {
                for (int c=0; c<tc; c++) {
                    if (pacificVisited[r][c] && atlanticVisited[r][c]) {
                        result.add(Arrays.asList(r, c));
                    }
                }
            }

            return result;
        }

        void dfs(int r, int c, boolean[][] visited, int prevHeight) {
            if (oob(r, c) || visited[r][c] || prevHeight > heights[r][c]) {
                return;
            }

            visited[r][c] = true;
            for (int[] dir : directions) {
                dfs(r + dir[0], c + dir[1], visited, heights[r][c]);
            }
        }

        boolean oob(int r, int c) {
            return r < 0 || c < 0 || r >= tr || c >= tc;

        }

    }
}
