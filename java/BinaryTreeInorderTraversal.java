import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public void DFSWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // first of all make sure we goes to left bottom of the tree
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // at this point curr should be null and we are at left bottom
            // start poping from stack so we goes from left child to parent
            curr = stack.pop();
            System.out.println(curr.val);
            curr = curr.right;
        }
    }
}
