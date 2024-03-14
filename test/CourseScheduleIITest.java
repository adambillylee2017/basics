import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CourseScheduleIITest {
    CourseScheduleII sol = new CourseScheduleII();

    @Test
    public void canFinish1() throws Exception {
        int numOfCourses = 2;
        int prerequisites[][] = {{1, 0}};

        int[] actual = sol.findOrder(numOfCourses, prerequisites);
        Arrays.stream(actual).forEach(
                System.out::println
        );

    }

    @Test
    public void canFinish2() throws Exception {
        int numOfCourses = 4;
        int prerequisites[][] = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        int[] actual = sol.findOrder(numOfCourses, prerequisites);
        Arrays.stream(actual).forEach(
                System.out::println
        );

    }
}