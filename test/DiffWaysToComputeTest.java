import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DiffWaysToComputeTest {
    DiffWaysToCompute.Solution sol = new DiffWaysToCompute.Solution();
    @Test
    public void testDiffWaysToCompute1() {
        List<Integer> integers = sol.diffWaysToCompute("1+2+3");
        System.out.println(integers);
    }

    @Test
    public void testDiffWaysToCompute2() {
        List<Integer> integers = sol.diffWaysToCompute("2*3-4*5");
        System.out.println(integers);
    }
}