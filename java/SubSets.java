import java.util.ArrayList;
import java.util.List;

public class SubSets {
    static class Solution {
        List<List<Integer>> result;
        public List<List<Integer>> subsets(int[] nums) {
            result = new ArrayList<>();
            dfs(nums, 0, new ArrayList<>());
            return result;
        }

        void dfs(int[] nums, int start, List<Integer> subSet) {
            if (start == nums.length) {
                result.add(new ArrayList<>(subSet));
                return;
            }

            dfs(nums, start+1, subSet);

            subSet.add(nums[start]);
            dfs(nums, start+1, subSet);
            subSet.remove(subSet.size()-1);
        }
    }
}
