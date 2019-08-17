import org.junit.Assert;
import org.junit.Test;

/**
 * Created by adamli on 6/28/16.
 */
public class PlusOneTest {
    PlusOne sol = new PlusOne();

    @Test
    public void testAddSameLengthWithCarry() throws Exception {
        Assert.assertArrayEquals(sol.plusOne(new int[]{1,1}), new int[]{1,2});
    }

    @Test
    public void testAddLength() throws Exception {
        Assert.assertArrayEquals(sol.plusOne(new int[]{9}), new int[]{1,0});
    }

}