import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 5/15/16.
 */
public class CoinChangeTest {
    CoinChange.Solution1 sol = new CoinChange.Solution1();
//    CoinChange.Solution2 sol = new CoinChange.Solution2();

    @Test
    public void coinChange1() throws Exception {
        int amount = 11;
        int coins[] = {1, 2, 5};
        assertEquals(3, sol.coinChange(coins, amount));
    }

    @Test
    public void coinChange2() throws Exception {
        int amount = 15;
        int coins[] = {1, 2, 5};
        assertEquals(3, sol.coinChange(coins, amount));
    }

    @Test
    public void coinChange3() throws Exception {
        int amount = 1;
        int coins[] = {1, 2, 5};
        assertEquals(1, sol.coinChange(coins, amount));
    }

    @Test
    public void coinChange4() throws Exception {
        int amount = 0;
        int coins[] = {1, 2, 5};
        assertEquals(0, sol.coinChange(coins, amount));
    }

    @Test
    public void coinChange5() throws Exception {
        int amount = 7163;
        int coins[] = {37,233,253,483};
        assertEquals(19, sol.coinChange(coins, amount));
    }

    @Test
    public void coinChange6() throws Exception {
        int amount = 9864;
        int coins[] = {411,412,413,414,415,416,417,418,419,420,421,422};
        assertEquals(24, sol.coinChange(coins, amount));
    }

}