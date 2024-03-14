import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SplitArrayIntoConsecutiveSubsequencesTest {
    SplitArrayIntoConsecutiveSubsequences.Solution sol = new SplitArrayIntoConsecutiveSubsequences.Solution();

    @Test
    public void testIsPossible1() {
        int[] nums = {1,2,3,3,4,5};
        Assert.assertTrue(sol.isPossible(nums));
    }

    @Test
    public void testIsPossible2() {
        int[] nums = {1,2,3,3,4,4,5,5};
        Assert.assertTrue(sol.isPossible(nums));
    }

    @Test
    public void testIsPossible3() {
        int[] nums = {1,2,3,4,4,5};
        Assert.assertFalse(sol.isPossible(nums));
    }
}