package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Integer>[] adj;
    private final int V;
    private int E;

    public Graph(int V) {
        this.V = V;
        adj = (List<Integer>[]) new List[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public int edges() {
        return E;
    }

    public int V() {
        return V;
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public void addEdge(int w, int u) {
        validateVertex(w);
        validateVertex(u);
        E++;
        adj[w].add(u);
        adj[u].add(w);
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("Vertex index is not in range of 0 to " + (V - 1) + ".");
        }
    }
}
