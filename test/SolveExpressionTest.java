import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 8/3/16.
 */
public class SolveExpressionTest {
    SolveExpression sol = new SolveExpression();

    @Test
    public void testExpressionTree() throws Exception {
        String input = "213+-";
        sol.createTree(input);

        // verify solve
        Assert.assertEquals(sol.solve(), -2);

        // verify storage
        Assert.assertEquals(sol.root.getExpression(), "213+-");
    }



}