import java.util.*;

public class SnakesAndLadders {

    static class Solution {
        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            boolean[] visited = new boolean[n * n + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            visited[1] = true;
            int steps = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int current = queue.poll();
                    if (current == n * n) {
                        return steps;
                    }
                    for (int j = 1; j <= 6; j++) {
                        int next = current + j;
                        if (next > n * n) break;
                        int[] rc = getRowCol(next, n);
                        if (board[rc[0]][rc[1]] != -1) {
                            next = board[rc[0]][rc[1]];
                        }
                        if (!visited[next]) {
                            visited[next] = true;
                            queue.add(next);
                        }

                    }
                }
                steps++;
            }
            return -1;
        }

        private int[] getRowCol(int index, int n) {
            int row = (index - 1) / n;
            int col = (index - 1) % n;
            if (row % 2 == 1) {
                col = n - 1 - col;
            }
            return new int[]{n - 1 - row, col};
        }
    }
}
