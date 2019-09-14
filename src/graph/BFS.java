package graph;

import java.lang.reflect.Array;
import java.util.*;

import static graph.DFS.getGraph;

public class BFS {
    private final boolean[] marked;    // visited or not
    private final int[] edgeTo;        // path from source vertex
    private final int[] dist;          // distance to source vertex
    private int count;                 // number of vertices reachable from source vertex
    private final int s;

    public BFS(Graph graph, int s) {
        this.s = s;
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        dist = new int[graph.V()];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        dist[s] = 0;
        marked[s] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for(int w : graph.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    dist[w] = dist[v] + 1;

                    queue.add(w);
                }
            }
        }
    }

    // get the path from s to v
    public Iterable<Integer> path(int v) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = v; i != s; i = edgeTo[i]) {
            deque.addFirst(i);
        }
        deque.addFirst(s);

        return deque;
    }

    public int count() {
        return this.count;
    }

    public static void main(String[] args) {
        Graph graph = getGraph();
        BFS bfs = new BFS(graph, 0);
        System.out.println(Arrays.toString(bfs.dist));
    }
}
