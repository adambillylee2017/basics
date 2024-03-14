import java.util.Arrays;

/**
 * Created by adamli on 5/15/16.
 */
public class CoinChange {
    static class Solution1 {
        int[] coins;
        int result = Integer.MAX_VALUE;

        public int coinChange(int[] coins, int amount) {
            this.coins = coins;

            Arrays.sort(coins);
            dfs(coins.length - 1, 0, amount);
            return result == Integer.MAX_VALUE ? -1 : result;
        }

        private void dfs(int index, int count, int amount) {
            if (amount == 0) {
                this.result = Math.min(count, result);
                return;
            }

            for (int curr = index; curr >= 0; curr--) {
                if (amount >= coins[curr]) {
                    dfs(curr, count + 1, amount - coins[curr]);
                }
            }

        }

    }

    static class Solution2 {
        int[] coins;
        int[] dp;

        public int coinChange(int[] coins, int amount) {
            this.coins = coins;
            this.dp = new int[amount + 1];

            Arrays.fill(dp, amount + 1);

            for (int sum = 0; sum <= amount; sum++) {
                if (sum == 0) {
                    dp[sum] = 0;
                }

                for (int coin : coins) {
                    if (sum >= coin) {
                        dp[sum] = Math.min(dp[sum], dp[sum - coin] + 1);
                    }
                }
            }

            return dp[amount] > amount ? -1 : dp[amount];
        }

    }
}
