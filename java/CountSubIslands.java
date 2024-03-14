public class CountSubIslands {
    static class Solution {
        int countSubs = 0;
        int tr;
        int tc;
        int[][] grid1;
        int[][] grid2;

        public int countSubIslands(int[][] grid1, int[][] grid2) {
            this.tr = grid1.length;
            this.tc = grid1[0].length;
            this.grid1 = grid1;
            this.grid2 = grid2;

            for (int r=0; r<tr; r++) {
                for (int c=0; c<tc; c++) {
                    if (dfs(r, c, true)) {
                        countSubs++;
                    }
                }
            }

            return countSubs;
        }

        boolean dfs(int r, int c, boolean isOrigin) {
            if (!inBound(r, c)) {
                return true;
            }

            if (grid2[r][c] == 0) {
                return !isOrigin;
            }

            if (grid1[r][c] == 0) {
                return false;
            }

            grid2[r][c] = 0;

            boolean down = dfs(r + 1, c, false);
            boolean up = dfs(r - 1, c, false);
            boolean right = dfs(r, c + 1, false);
            boolean left = dfs(r, c - 1, false);
            return down && up && right && left;
        }

        boolean inBound(int r, int c) {
            if (r<0 || r>=tr) {
                return false;
            }

            if (c<0 || c>=tc) {
                return false;
            }

            return true;
        }
    }
}
