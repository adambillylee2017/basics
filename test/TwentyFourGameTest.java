import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TwentyFourGameTest {
    TwentyFourGame.Solution sol = new TwentyFourGame.Solution();

    @Test
    public void test24Game1() {
        int[] cards = {4,1,8,7};
        Assert.assertTrue(sol.judgePoint24(cards));
    }

    @Test
    public void test24Game2() {
        int[] cards = {4,1,8,7};
        Assert.assertTrue(sol.judgePoint24(cards));
    }

    @Test
    public void test24Game3() {
        int[] cards = {1,5,9,1};
        Assert.assertFalse(sol.judgePoint24(cards));
    }

    @Test
    public void test24Game4() {
        int[] cards = {1,3,4,6};
        Assert.assertTrue(sol.judgePoint24(cards));
    }

    @Test
    public void test24Game5() {
        int[] cards = {1,9,1,2};
        Assert.assertTrue(sol.judgePoint24(cards));
    }

    @Test
    public void canGet24_1() {
        List<Double> path = Arrays.asList(1.0, 2.0, 9.0, 1.0);
        sol.path = path;
        System.out.println(
                sol.partition(0, path.size()-1)
        );

    }

    @Test
    public void canGet24_2() {
        List<Double> path = Arrays.asList(8.0, 3.0, 8.0, 3.0);
        sol.path = path;
        System.out.println(
                sol.partition(0, path.size()-1)
        );

    }
}