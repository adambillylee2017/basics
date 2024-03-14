public class MineSweeper {
    static class Solution {
        char[][] board;
        int tr;
        int tc;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        boolean[][] visited;


        public char[][] updateBoard(char[][] board, int[] click) {
            this.board = board;
            this.tr = board.length;
            this.tc = board[0].length;
            this.visited = new boolean[tr][tc];

            dfs(click[0], click[1], true);
            return board;
        }

        char dfs(int r, int c, boolean isOrigin) {
            if (oob(r, c)) {
                return ' ';
            }

            if (visited[r][c]) {
                return board[r][c];
            }

            char curr = board[r][c];
            visited[r][c] = true;

            if (curr == 'M') {
                if (isOrigin) {
                    board[r][c] = 'X';
                }
            } else if (curr == 'E') {
                int countX = 0;
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    char next = dfs(nr, nc, false);

                    if (next == 'X' || next == 'M') {
                        countX++;
                    }
                }

                if (countX == 0) {
                    board[r][c] = 'B';
                } else {
                    board[r][c] = (char) ('0' + countX);
                }
            }

            return board[r][c];
        }

        boolean oob(int r, int c) {
            return r < 0 || r >= tr || c < 0 || c >= tc;
        }

    }
}
