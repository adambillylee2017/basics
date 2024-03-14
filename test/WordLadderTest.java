import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordLadderTest extends TestCase {
    WordLadder sol = new WordLadder();

    public void testLadderLength() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        int exp = 5;
        int actual = sol.ladderLength(beginWord, endWord, wordList);

        Assert.assertEquals(exp, actual);
    }

    public void testLadderLength2() {
        String beginWord = "red";
        String endWord = "tax";
        List<String> wordList = Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");

        int exp = 4;
        int actual = sol.ladderLength(beginWord, endWord, wordList);

        Assert.assertEquals(exp, actual);
    }

}