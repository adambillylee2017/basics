package utils;

import java.util.List;

public class LinkedListUtils {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static class Node extends ListNode {
        public Node(int val) {
            super(val);
        }
    }

    public static ListNode build(String str) {
        return build(str, List.of("[", "]"), ",");
    }

    public static ListNode build(String str, List<String> brackets, String delimiter) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        dummy.next = curr;

        for (String bracket : brackets) {
            str = str.replace(bracket, "");
        }


        for (String s : str.split(delimiter)) {
            curr.next = new ListNode(Integer.parseInt(s));
            curr = curr.next;
        }

        return dummy.next;
    }

    public static String toString(ListNode head) {
        return LinkedListUtils.toString(head, List.of("[", "]"), ",");
    }

    public static String toString(ListNode head, List<String> brackets, String delimiter) {
        assert brackets.size() == 2;
        StringBuilder sb = new StringBuilder(brackets.get(0));

        while (head != null) {
            sb.append(head.val);
            sb.append(delimiter);
            head = head.next;
        }

        sb.setCharAt(sb.length() - 1, brackets.get(1).charAt(0));
        return sb.toString();
    }
}
