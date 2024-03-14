import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestValidParenthesesTest {
    LongestValidParentheses.Solution sol = new LongestValidParentheses.Solution();

    @Test
    public void testLongestValidParenthesesTest1() {
        Assert.assertEquals(2, sol.longestValidParentheses("()"));
    }

    @Test
    public void testLongestValidParenthesesTest2() {
        Assert.assertEquals(2, sol.longestValidParentheses("(()"));
    }

    @Test
    public void testLongestValidParenthesesTest3() {
        Assert.assertEquals(4, sol.longestValidParentheses(")()())"));
    }

    @Test
    public void testLongestValidParenthesesTest4() {
        Assert.assertEquals(6, sol.longestValidParentheses("()(())"));
    }

    @Test
    public void testLongestValidParenthesesTest5() {
        Assert.assertEquals(22, sol.longestValidParentheses(")(((((()())()()))()(()))("));
    }

    @Test
    public void testLongestValidParenthesesTest6() {
        Assert.assertEquals(2, (sol.longestValidParentheses( "(()(((()")));
    }
}