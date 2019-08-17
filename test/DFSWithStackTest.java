import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DFSWithStackTest {
    TreeNode root;

    @Before
    public void setUp() throws Exception {
        root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
    }

    @Test
    public void DFSWithStack() {
        DFSWithStack sol = new DFSWithStack();

        sol.DFSWithStack(root);
    }
}