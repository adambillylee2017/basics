import utils.LinkedListUtils.ListNode;
public class ReverseLinkedListII {
    static class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null || left == right) {
                return head;
            }

            int count = 1;

            // try finding left node
            ListNode lNode = head;
            ListNode lPrev = null;
            while (lNode != null) {
                if (count++ == left) {
                    break;
                }

                lPrev = lNode;
                lNode = lNode.next;
            }

            // find right and reverse
            ListNode rPrev = lNode;
            ListNode rNode = rPrev.next;
            while (rNode != null) {
                if (count++ == right) {
                    // fix array out of reverse range
                    lNode.next = rNode.next;
                    // reverse last node in range
                    rNode.next = rPrev;
                    break;
                }

                ListNode rNext = rNode.next;
                rNode.next = rPrev;
                rPrev = rNode;
                rNode = rNext;
            }

            // fix arrow entering reverse range
            if (lPrev != null) {
                lPrev.next = rNode;
            }

            // if started swapping from the first position, head would not be the starting node anymore
            // instead using rightN since its swapped to the first
            return left == 1 ? rNode : head;
        }
    }
}
