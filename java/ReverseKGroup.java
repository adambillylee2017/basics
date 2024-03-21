import utils.LinkedListUtils.ListNode;

public class ReverseKGroup {
    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode curr = head;
            ListNode prevEnd = null;
            ListNode result = null;

            while (curr != null) {
                Reversed reversed = reverse(curr, k);
                curr = reversed.nextStart;

                // connect end or previous reversed chain to current start
                if (prevEnd != null) {
                    prevEnd.next = reversed.start;
                }
                prevEnd = reversed.end;

                if (result == null) {
                    result = reversed.start;
                }
            }

            return result == null ? head : result;
        }

        Reversed reverse(ListNode head, int k) {
            if (length(head) < k) {
                return new Reversed(null, head, null);
            }

            // reset and start reverting
            int count = 0;
            ListNode curr = head;
            ListNode prev = null;
            while (count++ < k) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return new Reversed(curr, prev, head);
        }

        int length(ListNode head) {
            int len = 0;
            ListNode curr = head;

            while (curr != null) {
                curr = curr.next;
                len++;
            }

            return len;
        }

        static class Reversed {
            public ListNode nextStart;
            public ListNode start;
            public ListNode end;

            Reversed(ListNode nextStart, ListNode start, ListNode end) {
                this.nextStart = nextStart;
                this.start = start;
                this.end = end;
            }
        }
    }
}
