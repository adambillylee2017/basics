import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class CriticalConnectionsTest {
    CriticalConnections.Solution sol = new CriticalConnections.Solution();

    @Test
    public void test1() {
        Integer[][] arr = {{0, 1}, {1, 2}, {2, 0}, {1, 3}};
        List<List<Integer>> connections = Arrays.stream(arr)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        Integer[][] eArr = {{1, 3}};
        List<List<Integer>> expected = Arrays.stream(eArr)
                .map(Arrays::asList)
                .collect(Collectors.toList());

        List<List<Integer>> actual = sol.criticalConnections(4, connections);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        Integer[][] arr = {{0, 1}, {1, 2}, {2, 0}, {1, 3}, {3, 4}, {4, 5}, {5, 3}};
        List<List<Integer>> connections = Arrays.stream(arr)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        Integer[][] eArr = {{1, 3}};
        List<List<Integer>> expected = Arrays.stream(eArr)
                .map(Arrays::asList)
                .collect(Collectors.toList());

        List<List<Integer>> actual = sol.criticalConnections(6, connections);
        Assert.assertEquals(expected, actual);
    }

}