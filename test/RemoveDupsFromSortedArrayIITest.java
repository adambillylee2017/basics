import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 7/18/16.
 */
public class RemoveDupsFromSortedArrayIITest {
    RemoveDupsFromSortedArrayII sol = new RemoveDupsFromSortedArrayII();

    @Test
    public void testRemoveDuplicates() throws Exception {
        int[] nums = {1,1,1,2,2,3,4};
        Assert.assertEquals(sol.removeDuplicates(nums), 6);
    }

}