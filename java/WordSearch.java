public class WordSearch {
    static class Solution {
        char[][] board;
        int tr;
        int tc;
        boolean[][] visited;
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        public boolean exist(char[][] board, String word) {
            this.board = board;
            this.tr = board.length;
            this.tc = board[0].length;
            this.visited = new boolean[tr][tc];

            for (int r = 0; r < tr; r++) {
                for (int c = 0; c < tc; c++) {
                    if (dfs(r, c, word, 0)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean dfs(int r, int c, String word, int index) {
            char curr = board[r][c];
            if (index == word.length()-1) {
                return curr == word.charAt(word.length()-1);
            }

            if (curr != word.charAt(index)) {
                return false;
            }

            visited[r][c] = true;
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (valid(nr, nc)) {
                    if (dfs(nr, nc, word, index+1)) {
                        return true;
                    }
                }
            }
            visited[r][c] = false;

            return false;
        }

        private boolean valid(int nr, int nc) {
            if (nr < 0 || nr >= tr || nc < 0 || nc >= tc) {
                return false;
            }

            return !visited[nr][nc];
        }
    }

}