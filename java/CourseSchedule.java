import java.util.*;

public class CourseSchedule {
    Course[] courses;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        courses = new Course[numCourses];
        Set<Integer> noPreReq = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            noPreReq.add(i);
            courses[i] = new Course();
        }

        for (int[] preReq : prerequisites) {
            int after = preReq[0];
            int before = preReq[1];

            courses[after].requires.add(before);
            courses[before].unlocks.add(after);

            noPreReq.remove(after);
        }

        Queue<Integer> q = new LinkedList<>(noPreReq);
        int taken = 0;

        while (!q.isEmpty()) {
            int takeNow = q.poll();
            taken++;

            for (int toBeUnlocked : courses[takeNow].unlocks) {
                courses[toBeUnlocked].requires.remove(takeNow);

                if (courses[toBeUnlocked].requires.isEmpty()) {
                    q.offer(toBeUnlocked);
                }
            }
        }

        return taken == numCourses;
    }

    static class Course {
        Set<Integer> requires = new HashSet<>();
        Set<Integer> unlocks = new HashSet<>();
    }

}