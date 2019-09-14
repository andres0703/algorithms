package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static graph.DFS.getGraph;

public class DepthFirstPath {
    private final boolean[] marked;
    private final int[] edgeTo;
    private int count;              // number of vertices reachable from vertex s
    private final int s;

    // dfs from vertex s
    public DepthFirstPath(Graph g, int s) {
        this.s = s;
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];

        for (int w : g.adj(s)) {
            if (!marked[w]) {
                dfs(g, s, w);
            }
        }
    }

    private void dfs(Graph g, int from, int v) {
        edgeTo[v] = from;
        marked[v] = true;
        count++;
        for (int u : g.adj(v)) {
            if (!marked[u]) {
                dfs(g, v, u);
            }
        }
    }

    public int count() {
        return this.count;
    }

    public Iterable<Integer> path(int v) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            deque.addFirst(x);
        }
        deque.addFirst(s);

        return deque;
    }

    private static void printGraph(Graph graph) {
        for (int i = 0; i < graph.V(); i++) {
            System.out.println(i + ": " + graph.adj(i));
        }
    }

    private static Graph constructGraph() {
        return getGraph();
    }

    public static void main(String[] args) {
        Graph g = constructGraph();
        DepthFirstPath depthFirstPath = new DepthFirstPath(g, 1);

        System.out.println(depthFirstPath.count());
        System.out.println(depthFirstPath.path(5));
    }
}
