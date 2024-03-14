import org.junit.Test;

import static org.junit.Assert.*;

public class SplitArrayIntoFibonacciSequenceTest {
    SplitArrayIntoFibonacciSequence.Solution sol = new SplitArrayIntoFibonacciSequence.Solution();

    @Test
    public void testSplit1() {
        System.out.println(sol.splitIntoFibonacci("1101111"));
    }

    @Test
    public void testSplit2() {
        System.out.println(sol.splitIntoFibonacci("112358130"));
    }

    @Test
    public void testSplit3() {
        System.out.println(sol.splitIntoFibonacci("0123"));
    }

    @Test
    public void testSplit4() {
        System.out.println(sol.splitIntoFibonacci("123"));
    }

    @Test
    public void testSplit5() {
        System.out.println(sol.splitIntoFibonacci("5511816597"));
    }
}