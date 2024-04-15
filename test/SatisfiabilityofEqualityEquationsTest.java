import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SatisfiabilityofEqualityEquationsTest {
    SatisfiabilityofEqualityEquations.Solution sol = new SatisfiabilityofEqualityEquations.Solution();

    @Test
    public void test1() {
        String[] equations = {"c==c","b==d","x!=z"};
        boolean expected = true;

        Assert.assertEquals(expected, sol.equationsPossible(equations));
    }
}