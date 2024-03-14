public class ColoringABorder {
    static class Solution {
        int[][] grid;
        int targetColor;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        boolean[][] visited;

        public int[][] colorBorder(int[][] grid, int row, int col, int color) {
            this.grid = grid;
            this.targetColor = color;
            this.visited = new boolean[grid.length][grid[0].length];

            dfs(row, col, grid[row][col]);
            return grid;
        }

        void dfs(int r, int c, int startColor) {
            if (oob(r, c)  || visited[r][c]) {
                return;
            }

            visited[r][c] = true;
            if (grid[r][c] != startColor){
                return;
            }

            boolean isBoarder = false;
            for (int[] dir : directions) {
                if (oob(r + dir[0], c + dir[1])
                        || grid[r + dir[0]][c + dir[1]] != startColor) {
                    isBoarder = true;
                }
            }

            for (int[] dir : directions) {
                dfs(r + dir[0], c + dir[1], startColor);
            }

            if (isBoarder) {
                grid[r][c] = targetColor;
            }
        }

        boolean oob(int r, int c) {
            return r < 0 || r >= grid.length || c < 0 || c >= grid[0].length;
        }
    }
}
