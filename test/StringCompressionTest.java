import org.junit.Test;

import static org.junit.Assert.*;

public class StringCompressionTest {
    StringCompression.Solution sol = new StringCompression.Solution();
    @Test
    public void test1() {
        char[] chars = {'a','a','b','b','c','c','c'};
        int actual = sol.compress(chars);
        System.out.print(chars);
    }

    @Test
    public void test2() {
        char[] chars = {'a','a','a','b','b','a','a'};
        int actual = sol.compress(chars);
        System.out.print(chars);
    }
}