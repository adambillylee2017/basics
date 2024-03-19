import utils.LinkedListUtils.ListNode;

public class SortList {
    static class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode mid = findMid(head);
            ListNode left = sortList(head);
            ListNode right = sortList(mid);

            return mergeSort(left, right);
        }

        ListNode findMid(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow;
        }

        ListNode mergeSort(ListNode left, ListNode right) {
            ListNode result = new ListNode(-1);
            ListNode dummy = new ListNode(-1);
            dummy.next = result;

            while (left != null && right != null) {
                if (left.val <= right.val) {
                    result.next = left;
                    left = left.next;
                } else {
                    result.next = right;
                    right = right.next;
                }

                result = result.next;
            }

            result.next = left == null ? right : left;

            return dummy.next;
        }
    }
}
