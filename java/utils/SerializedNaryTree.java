package utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializedNaryTree {

    // Definition for a Node.
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    static class Codec {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            if (root == null) {
                return "[]";
            }

            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            List<String> strs = new LinkedList<>();

            while (!q.isEmpty()) {
                int len = q.size();
                for (int i = 0; i < len; i++) {
                    Node curr = q.poll();

                    if (curr != null) {
                        strs.add(String.valueOf(curr.val));
                        for (Node n : curr.children) {
                            q.offer(n);
                        }

                        if (curr.children.isEmpty()) {
                            q.offer(null);
                        }
                    }

                    if (curr == null) {
                        strs.add("null");
                    }
                }
                strs.add("#");
            }

            while (strs.get(strs.size() - 1).equals("null")) {
                strs.remove(strs.size() - 1);
            }

            return "[" + String.join(",", strs) + "]";
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if (data.equals("[]")) {
                return null;
            }

            data = data
                    .replace("[", "")
                    .replace("]", "");
            String[] nodeStrs = data.split(",");

            Node root = buildNode(nodeStrs[0]);
            Queue<Node> q = new LinkedList<>();
            q.offer(root);

            int cnt = 1;
            while (!q.isEmpty()) {
                Node curr = q.poll();

                if (cnt < nodeStrs.length) {
                    Node node = buildNode(nodeStrs[cnt++]);

                    if (node == null) {
                        break;
                    } else {
                        curr.children.add(node);
                        q.offer(node);
                    }
                }
            }

            return root;
        }

        private Node buildNode(String nodeStr) {
            if (nodeStr.equals("null")) {
                return null;
            } else {
                return new Node(Integer.parseInt(nodeStr), new ArrayList<>());
            }
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
