public class StringCompression {
    static class Solution {
        char[] chars;

        public int compress(char[] chars) {
            this.chars = chars;
            int curr = 0;

            int startInd = 0;
            while (curr < chars.length) {
                char c = chars[curr];
                int groupCnt = 0;

                while (curr < chars.length && chars[curr] == c) {
                    groupCnt++;
                    curr++;
                }

                startInd = modify(c, startInd, groupCnt);
            }

            return startInd;
        }

        private int modify(char c, int startIdx, int groupCnt) {
            chars[startIdx] = c;

            if (groupCnt > 1) {
                return fillGroupCnt(startIdx + 1, groupCnt);
            } else {
                return startIdx + 1;
            }
        }

        private int fillGroupCnt(int startIdx, int groupCnt) {
            char[] countArr = String.valueOf(groupCnt).toCharArray();

            int i = 0;
            for (; i < countArr.length; i++) {
                chars[startIdx + i] = countArr[i];
            }

            return startIdx + i;
        }
    }
}
