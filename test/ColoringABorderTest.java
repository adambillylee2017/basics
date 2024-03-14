import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColoringABorderTest {
    ColoringABorder.Solution sol = new ColoringABorder.Solution();

    @Test
    public void test1() {
        int[][] grid = {
                {1, 2, 2},
                {2, 3, 2}
        };
        int[][] expected = {
                {1, 3, 3},
                {2, 3, 3}
        };

        int[][] actuals = sol.colorBorder(grid, 0, 1, 3);
        prettyPrint(actuals);

        Assert.assertEquals(expected, actuals);
    }

    @Test
    public void test2() {
        int[][] grid = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int[][] expected = {
                {2, 2, 2},
                {2, 1, 2},
                {2, 2, 2}
        };

        int[][] actuals = sol.colorBorder(grid, 1, 1, 2);
        prettyPrint(actuals);

        Assert.assertEquals(expected, actuals);
    }

    void prettyPrint(int[][] grid) {
        for (int[] row : grid) {
            for (int c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}