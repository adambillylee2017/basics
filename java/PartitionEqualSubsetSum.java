import java.util.Arrays;

public class PartitionEqualSubsetSum {
    class Solution {
        int[] nums;
        int target;
        boolean[] visited;
        int visitedCount = 0;

        public boolean canPartition(int[] nums) {
            int tSum = Arrays.stream(nums).sum();

            if (tSum % 2 != 0) {
                return false;
            }

            this.nums = nums;
            this.target = tSum / 2;
            this.visited = new boolean[nums.length];

            Arrays.sort(this.nums);
            return dfs(0, target, 0);
        }

        private boolean dfs(int curr, int remains, int partitions) {
            if (partitions == 2) {
                return visitedCount == nums.length;
            }

            if (remains == 0) {
                return dfs(0, target, partitions + 1);
            }

            for (int i = curr; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }

                if (remains - nums[i] >=0) {
                    visited[i] = true;
                    visitedCount++;
                    if (dfs(i+1, remains-nums[i], partitions)) {
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
