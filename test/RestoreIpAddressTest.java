import org.junit.Test;

import static org.junit.Assert.*;

public class RestoreIpAddressTest {
    RestoreIpAddress.Solution sol = new RestoreIpAddress.Solution();
    @Test
    public void restoreIpAddress1() {
        System.out.println(
                sol.restoreIpAddresses("25525511135"));
    }

}