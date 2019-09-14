package graph;

import java.util.*;

/**
 *  topological sort using Kahn's algorithm(BFS).
 *
 */
public class TopologicalSort {

    public List<Integer> topologicalSort(int n, int[][] edges) {
        List<Integer> sorted = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[n];

        // initialize adjacency list
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // construct adjacency list and indegree array
        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            indegree[edges[i][1]]++;
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int v = queue.poll();
            sorted.add(v);

            for (int w : adj[v]) {
                indegree[w]--;
                if (indegree[w] == 0) {
                    queue.add(w);
                }
            }
        }

        // no topological sort
        if (sorted.size() != n) {
            throw new IllegalArgumentException("No topological sort of the graph.");
        }

        return sorted;
    }

    private static int[][] constructEdges() {
        return new int[][]{{0,1}, {1,2}, {1,4}, {1,5}, {5,2}, {5,9}, {2,3},{2,8}, {3,6}, {6,7}, {6,9}};
    }

    public static void main(String[] args) {
        TopologicalSort topologicalSort = new TopologicalSort();
        System.out.println(Arrays.toString(topologicalSort.topologicalSort(10, constructEdges()).toArray()));
    }
}
