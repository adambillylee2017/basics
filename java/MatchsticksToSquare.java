import java.util.Arrays;

public class MatchsticksToSquare {
    static class Solution {
        int[] matchsticks;
        int targetLength;

        public boolean makesquare(int[] matchsticks) {
            this.matchsticks = matchsticks;
            // sort
            Arrays.sort(matchsticks);

            int sum = Arrays.stream(matchsticks).sum();
            if (sum % 4 != 0) {
                return false;
            }
            targetLength = sum / 4;

            // reverse loop through matching so that longer match goes first
            return dfs(matchsticks.length - 1, new int[4]);
        }


        public boolean dfs(int curr, int[] sideSum) {
            // base case
            if (curr == -1) {
                return validSquare(sideSum);
            }

            // loop through all 4 sides and pick one to put match in
            for (int side = 0; side < 4; side++) {
                if (sideSum[side] + matchsticks[curr] <= targetLength) {
                    sideSum[side] += matchsticks[curr];
                    if (dfs(curr - 1, sideSum)) {
                        return true;
                    }
                    sideSum[side] -= matchsticks[curr];
                }
            }

            return false;
        }

        private boolean validSquare(int[] sideSum) {
            return sideSum[0] == targetLength && sideSum[1] == targetLength && sideSum[2] == targetLength && sideSum[3] == targetLength;
        }
    }

}
