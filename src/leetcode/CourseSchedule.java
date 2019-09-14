package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 *  Leetcode No.207 course schedule
 *
 *  Using dfs cycle detection to check if courses can be completed.
 *  O(n) time, O(n) space
 *
 */
public class CourseSchedule {
    private boolean[] marked;
    private boolean[] onStack;
    private boolean hasCycle;

    public boolean canFinish(int n, int[][] courses) {
        marked = new boolean[n];
        onStack = new boolean[n];
        List<Integer>[] adj = new List[n];

        // initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // construct adjacency list
        for (int i = 0; i < courses.length; i++) {
            adj[courses[i][0]].add(courses[i][1]);
        }

        for (int i = 0; i < n; i++) {
            if (!marked[i]) dfs(adj, i);
        }

        return !hasCycle;
    }

    private void dfs(List<Integer>[] adj, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int w : adj[v]) {
            if (hasCycle) return;

            if (onStack[w]) {
                hasCycle = true;
                return;
            }

            else if (!marked[w]) {
                dfs(adj, w);
            }
        }
        onStack[v] = false;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] courses = new int[][]{{0,1}, {1,2}, {1,4}, {4,2}, {2,5}, {2,3}, {5,1}};
        System.out.println(courseSchedule.canFinish(6, courses));
    }
}
