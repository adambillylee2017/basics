import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumAddToMakeParenthesesValidTest {
    MinimumAddToMakeParenthesesValid.Solution sol = new MinimumAddToMakeParenthesesValid.Solution();

    @Test
    public void testMinimumAddToMakeParenthesesValid1() {
        String s = "()";
        int expected = 0;
        Assert.assertEquals(expected, sol.minAddToMakeValid(s));
    }

    @Test
    public void testMinimumAddToMakeParenthesesValid2() {
        String s = "(()";
        int expected = 1;
        Assert.assertEquals(expected, sol.minAddToMakeValid(s));
    }

    @Test
    public void testMinimumAddToMakeParenthesesValid3() {
        String s = "())";
        int expected = 1;
        Assert.assertEquals(expected, sol.minAddToMakeValid(s));
    }

    @Test
    public void testMinimumAddToMakeParenthesesValid4() {
        String s = ")()(";
        int expected = 2;
        Assert.assertEquals(expected, sol.minAddToMakeValid(s));
    }

    @Test
    public void testMinimumAddToMakeParenthesesValid5() {
        String s = "()()";
        int expected = 0;
        Assert.assertEquals(expected, sol.minAddToMakeValid(s));
    }

    @Test
    public void testMinimumAddToMakeParenthesesValid6() {
        String s = "))((";
        int expected = 4;
        Assert.assertEquals(expected, sol.minAddToMakeValid(s));
    }
}