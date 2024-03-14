import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/2/16.
 */
public class WordBreakTest {
    WordBreak.Solution sol = new WordBreak.Solution();

    @Test
    public void wordBreak() throws Exception {
        List<String> wordDict  = new ArrayList<>();
        wordDict.add("bob");
        wordDict.add("cat");
        wordDict.add("rob");

        String input1 = "bob";
        String input2 = "bobcat";
        String input3 = "catbob";
        String input4 = "bobrob";
        String input5 = "bobrox";

        assertTrue(sol.wordBreak(input1, wordDict));
        assertTrue(sol.wordBreak(input2, wordDict));
        assertTrue(sol.wordBreak(input3, wordDict));
        assertTrue(sol.wordBreak(input4, wordDict));
        assertFalse(sol.wordBreak(input5, wordDict));
    }

    @Test
    public void wordBreak2() throws Exception {
        List<String> wordDict  = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");

        String input1 = "applepenapple";

        assertTrue(sol.wordBreak(input1, wordDict));
    }

}