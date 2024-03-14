import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfProvincesTest {
    NumberOfProvinces.Solution sol = new NumberOfProvinces.Solution();

    @Test
    public void test1() {
        int [][] isConnected = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        int expected = 2;
        int actual = sol.findCircleNum(isConnected);

        Assert.assertEquals(expected, actual);
    }

}