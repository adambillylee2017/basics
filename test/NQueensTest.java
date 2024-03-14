import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 3/19/16.
 */
public class NQueensTest {
    NQueens.Solution sol = new NQueens.Solution();

    @Test
    public void eightQueens() throws Exception {
        int n = 4;
        List<List<String>> rst = sol.solveNQueens(n);
        System.out.println(rst);
    }
}