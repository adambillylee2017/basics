import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvaluationDivisionTest {
    EvaluationDivision.Solution sol = new EvaluationDivision.Solution();

    @Test
    public void test1() {
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {
                {"a", "c"},
                {"b", "a"},
                {"a", "e"},
                {"a", "a"},
                {"x", "x"}
        };

        double[] expected = {6.00000,0.50000,-1.00000,1.00000,-1.00000};
        double[] actual = sol.calcEquation(toList(equations), values, toList(queries));
        Assert.assertArrayEquals(expected, actual, 0.0001);
    }

    @Test
    public void test2() {
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {
                {"a", "c"},
                {"b", "a"},
                {"a", "e"},
                {"a", "a"},
                {"x", "x"}
        };


        double[] expected = {6.00000,0.50000,-1.00000,1.00000,-1.00000};
        double[] actual = sol.calcEquation(toList(equations), values, toList(queries));
        Assert.assertArrayEquals(expected, actual, 0.0001);
    }

    List<List<String>> toList(String[][] arr) {
        List<List<String>> result = new ArrayList<>();
        for (String[] a : arr) {
            result.add(Arrays.asList(a));
        }
        return result;
    }
}