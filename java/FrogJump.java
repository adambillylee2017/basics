import java.util.HashMap;
import java.util.Map;

public class FrogJump {
    static class Solution1 {
        public boolean canCross(int[] stones) {
            int totalStones = stones.length;

            boolean[][] dp = new boolean[totalStones][totalStones];
            dp[0][0] = true;

            for (int to = 0; to < totalStones; to++) {
                for (int from = to - 1; from >= 0; from--) {
                    int jump = stones[to] - stones[from];
                    if (jump > from + 1) {
                        break;
                    }

                    if (dp[from][jump - 1] || dp[from][jump] || dp[from][jump + 1]) {
                        dp[to][jump] = true;
                        if (to == totalStones - 1) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }

    static class Solution2 {
        int[] stones;
        Map<String, Boolean> memo;

        public boolean canCross(int[] stones) {
            this.stones = stones;
            this.memo = new HashMap<>();
            return dfs(0, 1, -1);
        }

        boolean dfs(int from, int to, int prev) {
            if (to == stones.length - 1) {
                return validJump(from, to, prev);
            }

            String key = encode(from, to , prev);
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            if (!validJump(from, to, prev)) {
                memo.put(key, false);
                return false;
            }

            for (int next = to + 1; next < stones.length; next++) {
                if (dfs(to, next, from)) {
                    memo.put(key, true);
                    return true;
                }
                memo.put(key, false);
            }

            memo.put(key, false);
            return false;
        }

        boolean validJump(int from, int to, int prev) {
            // first jump from stone0 to stone1 is always valid
            if (from == 0 && to == 1) {
                return stones[to] - stones[from] == 1;
            }

            int lastJump = stones[from] - stones[prev];
            int currJump = stones[to] - stones[from];

            return currJump - lastJump == 0 ||
                    currJump - lastJump == 1 ||
                    currJump - lastJump == -1;
        }

        String encode(int from, int to, int prev) {
            return from + "," + to + "," + prev;
        }

    }
}
