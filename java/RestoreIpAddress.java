import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestoreIpAddress {
    static class Solution {
        String s;
        List<String> ipAddresses;

        public List<String> restoreIpAddresses(String s) {
            this.s = s;
            this.ipAddresses = new ArrayList<>();

            dfs(0, new ArrayList<>());
            return ipAddresses;
        }

        public void dfs(int start, List<String> address) {
            if (start == s.length() && address.size() == 4) {
                String addressStr = address.stream()
                        .collect(Collectors.joining("."));
                ipAddresses.add(addressStr);
                return;
            }

            if (address.size() >= 4) {
                return;
            }

            for (int end = start; end < s.length() && end - start <= 3; end++) {
                String tmp = s.substring(start, end + 1);
                if (valid(tmp)) {
                    address.add(tmp);
                    dfs(end + 1, address);
                    address.remove(address.size() - 1);
                }
            }
        }

        private boolean valid(String s) {
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }

            if (s.charAt(0) == '0' && s.length() > 1) {
                return false;
            }

            int i = Integer.parseInt(s);
            return i >= 0 && i <= 255;
        }
    }
}
