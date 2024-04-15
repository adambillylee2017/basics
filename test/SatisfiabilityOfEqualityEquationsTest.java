import org.junit.Assert;
import org.junit.Test;

public class SatisfiabilityOfEqualityEquationsTest {
    SatisfiabilityOfEqualityEquations.Solution sol = new SatisfiabilityOfEqualityEquations.Solution();

    @Test
    public void test1() {
        String[] equations = {"c==c","b==d","x!=z"};
        boolean expected = true;

        Assert.assertEquals(expected, sol.equationsPossible(equations));
    }
}