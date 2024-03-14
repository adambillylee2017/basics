import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by adamli on 2/4/16.
 * all permutations with length = input length
 * with no order
 */
public class Permutation {
    static class Solution {
        List<List<Integer>> permutations;

        public List<List<Integer>> permute(int[] nums) {
            permutations = new ArrayList<>();

            dfs(nums,  new HashSet<>(), new ArrayList<>());
            return permutations;
        }

        public void dfs(int[] nums,Set<Integer> visited, List<Integer> permutation) {
            if (permutation.size() == nums.length) {
                permutations.add(new ArrayList<>(permutation));
                return;
            }

            for (int curr : nums) {
                if (visited.contains(curr)) {
                    continue;
                }

                visited.add(curr);
                permutation.add(curr);
                dfs(nums, visited, permutation);
                visited.remove(curr);
                permutation.remove(permutation.size() - 1);
            }
        }
    }}
