package utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LinkedListArrayUtilsTest {
    @Test
    public void test1() {
        String str = "[4,2,1,3]";
        LinkedListUtils.ListNode head = LinkedListUtils.build(str);
        LinkedListUtils.ListNode curr = head;

        for (int expected : List.of(4, 2, 1, 3)) {
            Assert.assertEquals(expected, curr.val);
            curr = curr.next;
        }

        Assert.assertEquals(str, LinkedListUtils.toString(head));
    }
}