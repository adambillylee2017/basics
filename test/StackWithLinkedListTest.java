import org.junit.Assert;
import org.junit.Test;

/**
 * Created by adamli on 6/28/16.
 */
public class StackWithLinkedListTest {
    StackWithLinkedList sol = new StackWithLinkedList();

    @Test
    public void testStack() throws Exception {
        sol.add(1);
        Assert.assertEquals(sol.peak(), 1);
        Assert.assertEquals(sol.pop(), 1);

        sol.add(1);
        sol.add(2);
        sol.add(3);

        Assert.assertEquals(sol.size(), 3);
        Assert.assertEquals(sol.peak(), 3);
        Assert.assertEquals(sol.pop(), 3);

        Assert.assertEquals(sol.size(), 2);
        Assert.assertEquals(sol.peak(), 2);
        Assert.assertEquals(sol.pop(), 2);

        Assert.assertEquals(sol.size(), 1);
        Assert.assertEquals(sol.peak(), 1);
        Assert.assertEquals(sol.pop(), 1);

        sol.add(1);
        Assert.assertEquals(sol.size(), 1);
        Assert.assertEquals(sol.peak(), 1);

        sol.add(2);
        sol.add(3);
        Assert.assertEquals(sol.size(), 3);


        Assert.assertEquals(3, sol.peak());
        Assert.assertEquals(3, sol.pop());


        Assert.assertEquals(2, sol.peak());
        Assert.assertEquals(2, sol.pop());
    }

    @Test(expected = Exception.class)
    public void testExceptionPeak() throws Exception {
        sol = new StackWithLinkedList();

        sol.peak();
    }

    @Test(expected = Exception.class)
    public void testExceptionPop() throws Exception {
        sol = new StackWithLinkedList();

        sol.pop();
    }
}