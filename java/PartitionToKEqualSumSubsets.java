import java.util.*;

public class PartitionToKEqualSumSubsets {
    static class Solution {
        int[] nums;
        int target;
        boolean[] visited;
        int visitedCount = 0;

        public boolean canPartitionKSubsets(int[] nums, int k) {
            this.nums = sortDesc(nums);
            this.visited = new boolean[this.nums.length];

            if (Arrays.stream(nums).sum() % k != 0) {
                return false;
            }

            this.target = Arrays.stream(nums).sum() / k;
            return dfs(target, 0, k);
        }

        private int[] sortDesc(int[] nums) {
            Arrays.sort(nums);
            int[] reverse = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                reverse[i] = nums[nums.length - 1 - i];
            }
            return reverse;
        }

        private boolean dfs(int sum, int start, int partitionCount) {
            if (partitionCount == 0) {
                return visitedCount == nums.length;
            }

            if (sum == 0) {
                return dfs(target, 0, partitionCount - 1);
            }

            for (int i = start; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }

                int remains = sum - nums[i];

                if (remains >= 0) {
                    visited[i] = true;
                    visitedCount++;
                    if (dfs(remains, i, partitionCount)) {
                        return true;
                    }
                    visited[i] = false;
                    visitedCount--;
                }
            }

            return false;
        }
    }

}
