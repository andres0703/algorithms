package graph;

import java.util.Stack;

public class Bipartite {
    private final boolean[] marked;
    private final boolean[] color;
    private final int[] edgeTo;
    private boolean isBipartite;
    private Stack<Integer> cycle;

    public Bipartite(Graph graph) {
        marked = new boolean[graph.V()];
        color = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        isBipartite = true;

        for (int i = 0; i < graph.V(); i++) {
            if (!marked[i]) {
                dfs(graph, edgeTo[i], i);
            }
        }

        // if graph is bipartite, print the colors, otherwise print the odd cycle
        if (isBipartite) {
            System.out.println("This graph is bipartite.");
            printColors();
        } else {
            System.out.println("This graph is not bipartite.");
            System.out.println(this.cycle());
        }
    }

    // return the color of vertex v
    public boolean color(int v) {
        if (!isBipartite) {
            throw new UnsupportedOperationException("The graph is not bipartite.");
        }
        validateVertex(v);
        return color[v];
    }

    public void printColors() {
        if (!isBipartite) {
            throw new UnsupportedOperationException("Graph is not bipartite.");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < color.length; i++) {
            if (color[i]) sb.append("blue  ");
            else sb.append("red  ");
        }
        System.out.println(sb.toString().trim());
    }

    private void dfs(Graph graph, int from, int v) {
        marked[v] = true;
        edgeTo[v] = from;
        color[v] = !color[from];

        for (int w : graph.adj(v)) {

            if (cycle != null) return;

            if (!marked[w]) {
                dfs(graph, v, w);
            }

            // odd cycle detected
            else if (color[w] == color[v]) {
                isBipartite = false;

                cycle = new Stack<>();
                for (int i = v; i != w; i = edgeTo[i]) {
                    System.out.println(i);
                    cycle.push(i);
                }
                cycle.push(w);
                cycle.push(w);
            }
        }
    }

    public boolean isBipartite() {
        return isBipartite;
    }

    public Iterable<Integer> cycle() {
        if (isBipartite) {
            throw new UnsupportedOperationException("Graph is bipartite.");
        }
        return cycle;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= marked.length) {
            throw new IllegalArgumentException(v + " is not in range of 0 to " + (marked.length - 1));
        }
    }

    private static Graph getGraph() {
        Graph graph = new Graph(6);
        graph.addEdge(0,1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        //graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        return graph;
    }

    public static void main(String[] args) {
        Graph graph = getGraph();
        Bipartite bipartite = new Bipartite(graph);
    }
}
