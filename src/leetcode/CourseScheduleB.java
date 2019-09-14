package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 *  Leetcode No.207 course schedule
 *
 *  Uses Kahn's algorithm topological sort, if topological sort exists, then the courses can be finished.
 *
 *  time: O(n), space: O(n)
 */
public class CourseScheduleB {

    public boolean canFinish(int n, int[][] courses) {
        List<Integer> res = new ArrayList<>();
        List<Integer>[] adj = new List[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];
        for (int i = 0; i < courses.length; i++) {
            adj[courses[i][0]].add(courses[i][1]);
            indegree[courses[i][1]]++;
        }

        // add vertices with 0 indegree to the queue
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int v = queue.poll();
            res.add(v);

            for (int w : adj[v]) {
                indegree[w]--;
                if (indegree[w] == 0) {
                    queue.add(w);
                }
            }
        }

        return res.size() == n;
    }

    public static void main(String[] args) {
        CourseScheduleB courseSchedule = new CourseScheduleB();
        int[][] courses = new int[][]{{0,1}, {1,2}, {1,4}, {4,2}, {2,5}, {2,3}};
        System.out.println(courseSchedule.canFinish(6, courses));
    }
}
