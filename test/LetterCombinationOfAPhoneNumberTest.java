import org.junit.Test;

import static org.junit.Assert.*;

public class LetterCombinationOfAPhoneNumberTest {
    LetterCombinationOfAPhoneNumber.Solution sol =
            new LetterCombinationOfAPhoneNumber.Solution();

    @Test
    public void testLetterComb1() {
        System.out.println(sol.letterCombinations("23"));
    }
}