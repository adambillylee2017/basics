import org.junit.Assert;
import org.junit.Test;
import utils.LinkedListUtils;

import static org.junit.Assert.*;

public class ReverseKGroupTest {
    ReverseKGroup.Solution sol = new ReverseKGroup.Solution();

    @Test
    public void test1() {
        String str = "[1,2,3,4,5]";
        int k = 2;

        LinkedListUtils.ListNode actual = sol.reverseKGroup(LinkedListUtils.build(str), 2);
        String expectedStr = "[2,1,4,3,5]";

        Assert.assertEquals(
                expectedStr,
                LinkedListUtils.toString(actual)
        );
    }
}