package graph;

public class DFS {
    private final boolean[] marked;
    private int count;

    // DFS from source s
    public DFS(Graph g, int s) {
        int V = g.V();
        marked = new boolean[V];
        for (int w : g.adj(s)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    // check whether vertex v is marked
    public boolean marked(int v) {
        return marked[v];
    }

    // return the count of vertices connected to source s
    public int count() {
        return this.count;
    }

    private void dfs(Graph g, int w) {
        count++;
        marked[w] = true;
        for (int u : g.adj(w)) {
            if (!marked[u]) {
                dfs(g, u);
            }
        }
    }

    static Graph getGraph() {
        Graph g = new Graph(10);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);

        g.addEdge(6, 7);
        g.addEdge(7, 8);
        g.addEdge(7, 9);
        return g;
    }

    public static void main(String[] args) {
        Graph g = getGraph();
        DFS d = new DFS(g, 2);
        System.out.println(d.count);
    }
}
