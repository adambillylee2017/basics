import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class PacificAtlanticWaterFlowTest extends TestCase {
    PacificAtlanticWaterFlow.Solution sol = new PacificAtlanticWaterFlow.Solution();

    @Test
    public void testPacificAtlantic() {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };


        List<List<Integer>> actual = sol.pacificAtlantic(heights);
    }

    @Test
    public void testPacificAtlantic2() {
        int[][] heights = {
                {1, 1},
                {1, 1},
                {1, 1}
        };

        List<List<Integer>> actual = sol.pacificAtlantic(heights);
    }
}