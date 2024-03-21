import org.junit.Assert;
import org.junit.Test;
import utils.LinkedListUtils;

public class ReverseLinkedListIITest {
    ReverseLinkedListII.Solution sol = new ReverseLinkedListII.Solution();

    @Test
    public void test1() {
        String str = "[1,2,3,4,5]";
        int left = 2;
        int right = 4;

        LinkedListUtils.ListNode head = LinkedListUtils.build(str);
        LinkedListUtils.ListNode actual = sol.reverseBetween(head, left, right);
        String expectedStr = "[1,4,3,2,5]";

        Assert.assertEquals(expectedStr, LinkedListUtils.toString(actual));
    }
}