import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MineSweeperTest {
    MineSweeper.Solution sol = new MineSweeper.Solution();

    @Test
    public void test1() {
        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};

        char[][] expected = {
                {'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}};

        int[] click = {3, 0}; // as an example
        char[][] result = sol.updateBoard(board, click);

        for (int i=0; i<result.length; i++) {
            for (int j=0; j<result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        // Assert the results, for instance:
        assertArrayEquals(expected, result);
    }

}
