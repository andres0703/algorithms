package graph;

import java.util.Stack;

public class Cycle {
    private final boolean[] marked;
    private Stack<Integer> cycle;
    private final int[] edgeTo;

    public Cycle(Graph graph) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];

        // check self loop
        // check parallel edges

        dfs(graph, -1, 0);
    }

    private void dfs(Graph graph, int from, int v) {
        marked[v] = true;
        edgeTo[v] = from;

        for (int w : graph.adj(v)) {

            // skip if a cycle is already found
            if (cycle != null) return;

            if (!marked[w]) {
                dfs(graph, v, w);
            }

            // cycle detected
            else if (w != from) {
                cycle = new Stack<>();
                for (int i = v; i != w; i = edgeTo[i]) {
                    cycle.push(i);
                }
                cycle.push(v);
                cycle.push(v);
            }
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> getCycle() {
        return cycle;
    }

    private static Graph getGraph() {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(3, 1);
        graph.addEdge(2, 6);
        graph.addEdge(3, 6);
        graph.addEdge(3, 5);
        return graph;
    }

    public static void main(String[] args) {
        Graph graph = getGraph();
        Cycle c = new Cycle(graph);
        if (c.hasCycle()) {
            System.out.println(c.getCycle());
        }
    }
}
