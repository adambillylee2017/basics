import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SnakesAndLaddersTest {
    SnakesAndLadders.Solution sol = new SnakesAndLadders.Solution();

    @Test
    public void test1() {
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };

        int actual = sol.snakesAndLadders(board);
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };

        int actual = sol.snakesAndLadders(board);
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[][] board = {
                {-1, 1, 2, -1},
                {2, 13, 15, -1},
                {-1, 10, -1, -1},
                {-1, 6, 2, 8}
        };

        int actual = sol.snakesAndLadders(board);
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[][] board = {
                {1, 1, -1},
                {1, 1, 1},
                {-1, 1, 1},
        };

        int actual = sol.snakesAndLadders(board);
        int expected = -1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int[][] board = {
                {-1,-1,16,6,-1},
                {-1,9,25,8,-1},
                {8,20,2,7,-1},
                {-1,-1,12,-1,-1},
                {-1,-1,-1,12,23}
        };

        int actual = sol.snakesAndLadders(board);
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }

}