package utils;

import org.junit.Assert;
import org.junit.Test;

public class TreeUtilsTest {

    @Test
    public void test1() {
        String str = "[0,-3,9,-10,null,5]";
        TreeUtils.TreeNode root = TreeUtils.deserialize(str);
        String strBack = TreeUtils.toString(root);
        Assert.assertEquals(str, strBack);
    }

    @Test
    public void test2() {
        String str = "[1]";
        TreeUtils.TreeNode root = TreeUtils.deserialize(str);
        String strBack = TreeUtils.toString(root);
        Assert.assertEquals(str, strBack);
    }
}