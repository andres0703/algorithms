package leetcode;

import java.util.*;

/**
 *  Leetcode No.210 course schedule II
 *
 *  return topological sort (Kahn's algorithm) of all the courses.
 *
 */
public class CourseScheduleII {

    public int[] findOrder(int n, int[][] courses) {
        int[] res = new int[n];
        List<Integer>[] adj = new List[n];
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < courses.length; i++) {
            adj[courses[i][1]].add(courses[i][0]);
            indegree[courses[i][0]]++;
        }

        // add starting vertices to queue
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        int p = n - 1;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            res[p--] = v;

            for (int w : adj[v]) {
                indegree[w]--;
                if (indegree[w] == 0) {
                    queue.add(w);
                }
            }
        }

        return p == -1 ? res : null;
    }

    public static void main(String[] args) {
        CourseScheduleII courseSchedule = new CourseScheduleII();
        int[][] courses = new int[][]{{0,1}, {1,2}, {1,4}, {4,2}, {2,5}, {2,3}};
        System.out.println(Arrays.toString(courseSchedule.findOrder(6, courses)));
    }
}
