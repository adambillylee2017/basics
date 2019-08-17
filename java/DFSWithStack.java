import java.util.Stack;

public class DFSWithStack {
    public void DFSWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.println(curr.val);
            curr = curr.right;
        }
    }
}
