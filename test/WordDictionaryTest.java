import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordDictionaryTest {
    WordDictionary.Solution sol = new WordDictionary.Solution();

    @Test
    public void test1() {
        sol.addWord("bad");
        sol.addWord("dad");
        sol.addWord("mad");
        sol.addWord("pad");
        Assert.assertTrue(sol.search("bad"));
        Assert.assertTrue(sol.search(".ad"));
        Assert.assertTrue(sol.search("b.."));
    }
}