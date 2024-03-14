import org.junit.Test;

import static org.junit.Assert.*;

public class LetterCasePermutationTest {
    LetterCasePermutation.Solution sol = new LetterCasePermutation.Solution();

    @Test
    public void testLetterCasePermutation1() {
        System.out.println(sol.letterCasePermutation("abcd"));
    }

    @Test
    public void testLetterCasePermutation2() {
        System.out.println(sol.letterCasePermutation("a2cd"));
    }
}