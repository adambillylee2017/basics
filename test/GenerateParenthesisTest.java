import org.junit.Test;

import static org.junit.Assert.*;

public class GenerateParenthesisTest {
    GenerateParenthesis.Solution sol = new GenerateParenthesis.Solution();

    @Test
    public void testGenerateParenthesis1() {
        System.out.println(sol.generateParenthesis(3));
    }
}