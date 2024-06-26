import org.junit.Assert;
import org.junit.Test;

/**
 * Created by adamli on 6/27/16.
 */
public class QuickSelectTest {
    QuickSelect sol = new QuickSelect();

    @Test
    public void testSelectNonDup() {
        int[] test = {7, 9, 2, 3, 5, 1, 4};
        int[] sorted = {1, 2, 3, 4, 5, 7, 9};

        for (int i = 0; i < test.length; i++) {
            int tmp = sorted[i];
            Assert.assertEquals(sol.quickSelect(test, i + 1), tmp);
        }
    }

    @Test
    public void testSelectWithDup() {
        int[] test = new int[]{7, 5, 2, 3, 7, 1, 4};
        int[] sorted = {1, 2, 3, 4, 5, 7, 7};

        for (int i = 0; i < test.length; i++) {
            int tmp = sorted[i];
            Assert.assertEquals(sol.quickSelect(test, i + 1), tmp);
        }
    }

}