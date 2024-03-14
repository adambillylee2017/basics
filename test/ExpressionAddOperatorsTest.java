import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ExpressionAddOperatorsTest {
    ExpressionAddOperators.Solution sol = new ExpressionAddOperators.Solution();

    @Test
    public void testExpressionAddOperatorsTest1() {
        String num = "123";
        int target = 6;
        List<String> expected = Arrays.asList("1+2+3", "1*2*3");

        Assert.assertEquals(expected, sol.addOperators(num, target));
    }

    @Test
    public void testExpressionAddOperatorsTest2() {
        String num = "232";
        int target = 8;
        List<String> expected = Arrays.asList("2+3*2", "2*3+2");

        Assert.assertEquals(expected, sol.addOperators(num, target));
    }

    @Test
    public void testExpressionAddOperatorsTest3() {
        String num = "123456789";
        int target = 45;

        List<String> out = sol.addOperators(num, target);
        System.out.println(out);
    }

    @Test
    public void testCompute1() {
        // 1+2+3+4-5*6-7*8+9
        List<Long> numbers = Arrays.asList(1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l);
        List<Character> ops = Arrays.asList(
                '+', '+', '+', '-', '*', '-', '*', '+'
        );
        long expected = -67;

        Assert.assertEquals(expected, sol.compute(numbers, ops));
    }
}