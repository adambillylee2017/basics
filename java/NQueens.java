import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adamli on 3/19/16.
 */
public class NQueens {

    static class Solution {
        List<List<String>> result = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            dfs(0, getBoard(n));
            return result;
        }


        /**
         * Generates a board where index represent row and value represent the column of queen
         * this allows O(1) scan of each row to find queen position
         * value of -1 represent no queen have been placed on this row
         *
         * @param n The size of the board.
         * @return An array representing the board.
         */
        public int[] getBoard(int n) {
            int[] board = new int[n];
            Arrays.fill(board, -1);
            return board;
        }

        private void dfs(int r, int[] board) {
            if (r == board.length) {
                result.add(translate(board));
                return;
            }

            for (int c = 0; c < board.length; c++) {
                if (!attacked(board, r, c)) {
                    board[r] = c;
                    dfs(r + 1, board);
                    board[r] = -1;
                }
            }
        }

        /**
         * Determines if a queen at a given position on the chess board is attacked by another queen
         *
         * @param board   An array representing the board where index represents row and value represents the column of the queen
         * @param queenR  The row index of the queen
         * @param queenC  The column index of the queen
         * @return true if the queen is attacked, false otherwise
         */
        public boolean attacked(int[] board, int queenR, int queenC) {
            // check all previous row to make sure queen at current position is not attacked
            for (int boardR = 0; boardR < queenR; boardR++) {
                int boardC = board[boardR];

                if (boardC == queenC) {
                    return true;
                }

                // absolute slope = 1 -> attacked on diagonal
                if (Math.abs(boardR - queenR) == Math.abs(boardC - queenC)) {
                    return true;
                }
            }

            return false;
        }

        public List<String> translate(int[] board) {
            List<String> solution = new ArrayList<>();

            for (int r = 0; r < board.length; r++) {
                StringBuilder sb = new StringBuilder();
                int queenC = board[r];
                for (int c = 0; c < board.length; c++) {
                    if (c == queenC) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                solution.add(sb.toString());
            }

            return solution;
        }
    }

}
