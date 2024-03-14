import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CountSubIslandsTest extends TestCase {
    CountSubIslands.Solution sol = new CountSubIslands.Solution();

    /**
     * This method is used to test the countSubIslands functionality.
     *
     * It creates two grid arrays, grid1 and grid2, and then calls the countSubIslands method of the CountSubIslands.Solution class.
     * The countSubIslands method counts the number of sub-islands in grid2 that are also present in grid1.
     * The method iterates over each cell in grid2 and performs a depth-first search (DFS) to find sub-islands.
     * If a sub-island is found, the countSubs variable is incremented.
     * Finally, the method returns the countSubs variable.
     *
     * The expected result is then compared with the actual result using the Assert.assertEquals method.
     * If the two values are equal, the test will pass. Otherwise, it will fail.
     */
    @Test
    public void testCountSubIslands() {
        int[][] grid1 = {
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1}
        };
        int[][] grid2 = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1}
        };

        Assert.assertEquals(
                2,
                sol.countSubIslands(grid1, grid2)
        );

    }
}