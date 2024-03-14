import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/23/16.
 */
public class wordSearchTest {
    WordSearch.Solution sol = new WordSearch.Solution();

    @Test
    public void testExist() throws Exception {
        char[][] board = {
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'}
        };

        String word = "aaaaaaaaaaab";
        boolean actual = sol.exist(board, word);
        boolean expected = false;

        assertEquals(expected, actual);
    }

    @Test
    public void testExist1() throws Exception {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "SEE";
        boolean actual = sol.exist(board, word);
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    public void testExist2() throws Exception {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCB";
        boolean actual = sol.exist(board, word);
        boolean expected = false;

        assertEquals(expected, actual);
    }

    @Test
    public void testExist3() throws Exception {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";
        boolean actual = sol.exist(board, word);
        boolean expected = true;

        assertEquals(expected, actual);
    }
}