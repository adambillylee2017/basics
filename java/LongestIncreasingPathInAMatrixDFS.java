/**
 * Created by adamli on 6/20/16.
 */
public class LongestIncreasingPathInAMatrixDFS {
    int max = 0;
    int tr;
    int tc;
    int[][] pathLen;
    int[][] matrix;

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        this.matrix = matrix;
        tr = matrix.length;
        tc = matrix[0].length;
        pathLen = new int[tr][tc];

        for (int r = 0; r < tr; r++) {
            for (int c = 0; c < tc; c++) {
                helper(pathLen, r, c, Integer.MIN_VALUE);
                max = Math.max(pathLen[r][c], max);
            }
        }
        return max;
    }

    private int helper(int[][] pathLen, int r, int c, int prev) {
        if (oob(r, c))
            return 0;

        int curr = matrix[r][c];

        if (curr <= prev)
            return 0;

        if (pathLen[r][c] > 0)
            return pathLen[r][c];

        pathLen[r][c] = 1;

        int pathMax = 0;
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            pathMax = Math.max(pathMax, helper(pathLen, nr, nc, curr));
        }

        pathLen[r][c] += pathMax;
        return pathLen[r][c];
    }

    boolean oob(int r, int c) {
        return r < 0 || r >= tr || c < 0 || c >= tc;
    }
}
