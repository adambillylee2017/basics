import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfComponentsInAnUndirectedGraphTest {
    NumberOfComponentsInAnUndirectedGraph.Solution sol = new NumberOfComponentsInAnUndirectedGraph.Solution();

    @Test
    public void test1() {
        int n = 4;
        int[][] edges = {{0,1},{2,3},{1,2}};

        int expected = 1;
        Assert.assertEquals(expected, sol.countComponents(n, edges));
    }
}