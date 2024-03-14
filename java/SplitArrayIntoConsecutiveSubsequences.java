import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences {
    static class Solution {

        public boolean isPossible(int[] nums) {
            if (nums.length < 3) {
                return false;
            }

            // calculate frequency
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : nums) {
                increaseCountByOne(num, freq);
            }

            Map<Integer, Integer> sequence = new HashMap<>();
            for (int num : nums) {
                // this number is all used up
                if (freq.get(num) == 0) {
                    continue;
                } else if (sequence.getOrDefault(num - 1, 0) > 0) {
                    // first case: num is the largest of an ongoing sequence
                    increaseCountByOne(num, sequence);
                    decreaseCountByOne(num - 1, sequence);
                } else if (freq.getOrDefault(num + 1, 0) > 0
                        && freq.getOrDefault(num + 2, 0) > 0) {
                    // second case: num is not the max number in sequence, at least 2 numbers are larger
                    increaseCountByOne(num + 2, sequence);
                    decreaseCountByOne(num + 1, freq);
                    decreaseCountByOne(num + 2, freq);
                } else {
                    return false;
                }

                freq.put(num, freq.get(num) - 1);
            }

            return true;
        }

        void increaseCountByOne(int num, Map<Integer, Integer> map) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        void decreaseCountByOne(int num, Map<Integer, Integer> map) {
            map.put(num, map.get(num) - 1);
        }

    }
}
