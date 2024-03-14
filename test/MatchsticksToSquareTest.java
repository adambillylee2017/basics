import org.junit.Assert;
import org.junit.Test;

public class MatchsticksToSquareTest {
    MatchsticksToSquare.Solution solution = new MatchsticksToSquare.Solution();

    @Test
    public void testMatchSticksToSquare1() {
        int[] matchsticks = {1, 1, 2, 2, 2};
        Assert.assertTrue(solution.makesquare(matchsticks));
    }

    @Test
    public void testMatchSticksToSquare2() {
        int[] matchsticks = {2, 2, 2, 2, 6};
        Assert.assertFalse(solution.makesquare(matchsticks));
    }

    @Test
    public void testMatchSticksToSquare3() {
        int[] matchsticks = {2, 2, 2, 2, 2, 6};
        Assert.assertFalse(solution.makesquare(matchsticks));
    }

}