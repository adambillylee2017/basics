import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class PartitionToKEqualSumSubsetsTest {
    PartitionToKEqualSumSubsets.Solution sol = new PartitionToKEqualSumSubsets.Solution();

    @Test
    public void testDfs() {
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;

        Assert.assertTrue(sol.canPartitionKSubsets(nums, k));
    }

    @Test
    public void testDfs2() {
        int[] nums = {1,1,1,1,2,2,2,2};
        int k = 4;

        Assert.assertTrue(sol.canPartitionKSubsets(nums, k));
    }

    @Test
    public void testDfs3() {
        int[] nums = {114,96,18,190,207,111,73,471,99,20,1037,700,295,101,39,649};
        int k = 4;

        Assert.assertTrue(sol.canPartitionKSubsets(nums, k));
    }

    @Test
    public void testDfs4() {
        int[] nums = {10,1,10,9,6,1,9,5,9,10,7,8,5,2,10,8};
        int k = 11;

        Assert.assertFalse(sol.canPartitionKSubsets(nums, k));
    }

}