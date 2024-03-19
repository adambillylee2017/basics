package utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ListArrayUtilsTest {

    @Test
    public void build() {
        Assert.assertArrayEquals(
                new int[] {1, 2, 3, 4, 5},
                ListArrayUtils.toIntArr(List.of(1, 2, 3, 4, 5))
        );
    }

    @Test
    public void build1D() {
        String str1d = "[1,2,3,4,5]";
        int[] expected = {1,2,3,4,5};

        Assert.assertArrayEquals(
                expected,
                ListArrayUtils.build1D(str1d)
        );
    }

    @Test
    public void build2D() {
        String str2d = "[1,2,3,4,5],[6,7,8,9,10]";
        int[][] expected = {{1,2,3,4,5},{6,7,8,9,10}};

        Assert.assertArrayEquals(
                expected,
                ListArrayUtils.build2D(str2d)
        );
    }
}