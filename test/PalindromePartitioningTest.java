import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/18/16.
 */
public class PalindromePartitioningTest {
    PalindromePartitioning.Solution sol = new PalindromePartitioning.Solution();
    @Test
    public void partition() throws Exception {
        String input = "aabaa";

        List<List<String>> rst = sol.partition(input);
        System.out.println(rst);
    }

}