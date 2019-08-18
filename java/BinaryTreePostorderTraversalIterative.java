import java.util.Stack;

/**
 * Created by adamli on 4/9/16.
 */
public class BinaryTreePostorderTraversalIterative {
    Stack<TreeNode> stack = new Stack<>();

    // use stack to track and make sure each right tree is visited only once
    Stack<TreeNode> visited = new Stack<>();

    public void DFSWithTwoStacks(TreeNode root) {
        pushLeftBranchesToStack(root);

        while(!stack.isEmpty()) {
            TreeNode curr = stack.peek();

            // if no right tree, pop stack into visited stack
            if (curr.right == null) {
                printFromStack();
            } else {
                // if right tree is already visited, pop both stack and visited stack
                if (curr.right.equals(visited.peek())) {
                    visited.pop();
                    printFromStack();
                } else {
                    curr = curr.right;
                    pushLeftBranchesToStack(curr);
                }
            }
        }
    }

    private void pushLeftBranchesToStack(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    private void printFromStack() {
        TreeNode curr = stack.pop();
        System.out.println(curr.val);
        visited.push(curr);
    }
}
