/**
 * Created by adamli on 8/20/16.
 */
public class SudokuSolver {
    static class Solution {
        char[][] board;
        int tr;
        int tc;

        public void solveSudoku(char[][] board) {
            this.board = board;
            this.tr = board.length;
            this.tc = board[0].length;

            int count = countEmpty();
            dfs(0, 0, count);
        }

        public int countEmpty() {
            int count = 0;
            for (char[] row : board) {
                for (char c : row) {
                    if (c == '.') {
                        count++;
                    }
                }
            }
            return count;
        }

        public void dfs(int r, int c, int emptyCount) {
            if (emptyCount == 0) {
                return;
            }

            if (oob(r, c)) {
                return;
            }

            int nr = (c == tc - 1) ? r + 1 : r;
            int nc = (c == tc - 1) ? 0 : c + 1;

            char curr = board[r][c];
            if (curr != '.') {
                dfs(nr, nc, emptyCount);
                return;
            }

            for (char aChar = '1'; aChar <= '9'; aChar++) {
                if (valid(aChar, r, c)) {
                    board[r][c] = aChar;
                    dfs(nr, nc, emptyCount - 1);
                    if (countEmpty() == 0) {
                        return; // Board solved, stop further DFS
                    }
                    board[r][c] = '.';
                }
            }
        }

        public boolean valid(char val, int r, int c) {
            for (int i = 0; i < board.length; i++) {
                // loop through row
                if (board[i][c] == val) {
                    return false;
                }

                // loop through col
                if (board[r][i] == val) {
                    return false;
                }
            }

            // check 3*3 box
            if (!valid3By3(val, r, c)) {
                return false;
            }

            return true;
        }

        public boolean valid3By3(char val, int r, int c) {
            int rbox = r / 3 * 3;
            int cbox = c / 3 * 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[rbox + i][cbox + j] == val) {
                        return false;
                    }
                }
            }

            return true;
        }

        public boolean oob(int r, int c) {
            return r < 0 || r >= tr || c < 0 || c >= tc;
        }
    }
}