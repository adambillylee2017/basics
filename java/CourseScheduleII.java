import java.util.*;

public class CourseScheduleII {
    Course[] courses;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        courses = new Course[numCourses];

        Set<Integer> unlocked = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course();
            unlocked.add(i);
        }

        for (int[] preReq : prerequisites) {
            int after = preReq[0];
            int before = preReq[1];

            courses[after].requires.add(before);
            courses[before].unlocks.add(after);

            unlocked.remove(after);
        }

        int takeCnt = 0;
        Queue<Integer> q = new LinkedList<>(unlocked);
        List<Integer> path = new ArrayList<>();

        while (!q.isEmpty()) {
            int takeNow = q.poll();
            takeCnt++;
            path.add(takeNow);

            for (int toBeUnlocked : courses[takeNow].unlocks) {
                courses[toBeUnlocked].requires.remove(takeNow);

                if (courses[toBeUnlocked].requires.isEmpty()) {
                    q.offer(toBeUnlocked);
                }
            }
        }

        if (takeCnt != numCourses) {
            return new int[]{};
        } else {
            return path.stream().mapToInt(Integer::intValue).toArray();
        }

    }


    static class Course {
        Set<Integer> requires = new HashSet<>();
        Set<Integer> unlocks = new HashSet<>();

    }
}
