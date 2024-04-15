package utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtils {
    public static TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }

        data = data
                .replace("[", "")
                .replace("]", "");
        String[] nodeStrs = data.split(",");

        TreeNode root = buildNode(nodeStrs[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int cnt = 1;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr != null) {
                if (cnt == nodeStrs.length) break;
                curr.left = buildNode(nodeStrs[cnt++]);
                q.offer(curr.left);

                if (cnt == nodeStrs.length) break;
                curr.right = buildNode(nodeStrs[cnt++]);
                q.offer(curr.right);
            }
        }

        return root;
    }

    private static TreeNode buildNode(String nodeStr) {
        if (nodeStr.equals("null")) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(nodeStr));
        }
    }

    public static String toString(TreeNode node) {
        if (node == null) {
            return "[]";
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        List<String> strs = new LinkedList<>();

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode curr = q.poll();

                if (curr != null) {
                    strs.add(String.valueOf(curr.val));
                    q.offer(curr.left);
                    q.offer(curr.right);
                } else {
                    strs.add("null");
                }
            }
        }

        while (strs.get(strs.size() - 1).equals("null")) {
            strs.remove(strs.size() - 1);
        }

        return "[" + String.join(",", strs) + "]";
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
