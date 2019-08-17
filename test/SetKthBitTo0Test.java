import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 3/23/16.
 */
public class SetKthBitTo0Test {

    @Test
    public void set() throws Exception {
        int input = Integer.parseInt("10000100", 2);

        int expected = Integer.parseInt("10000000",2);
        int actual = SetKthBitTo0.set(input, 3);
        assertEquals(expected, actual);
    }
}