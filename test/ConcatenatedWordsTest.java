import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ConcatenatedWordsTest {
    ConcatenatedWords.Solution sol = new ConcatenatedWords.Solution();

    @Test
    public void test1() {
        String words[] = {"cat","dog","catdog"};
        List<String> allConcatenatedWordsInADict = sol.findAllConcatenatedWordsInADict(words);
        System.out.println(allConcatenatedWordsInADict);
    }

    @Test
    public void test2() {
        String words[] = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        List<String> allConcatenatedWordsInADict = sol.findAllConcatenatedWordsInADict(words);
        System.out.println(allConcatenatedWordsInADict);
    }
}