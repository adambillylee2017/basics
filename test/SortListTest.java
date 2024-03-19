import org.junit.Assert;
import org.junit.Test;
import utils.LinkedListUtils;

public class SortListTest {
    SortList.Solution sol = new SortList.Solution();

    @Test
    public void test1() {
        String str = "[4,2,1,3]";
        LinkedListUtils.ListNode node = LinkedListUtils.build(str);
        sol.sortList(node);

        Assert.assertEquals(
                "[1,2,3,4]",
                LinkedListUtils.toString(node)
        );
    }
}