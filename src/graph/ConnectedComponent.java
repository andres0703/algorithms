package graph;

import java.util.Arrays;

import static graph.DFS.getGraph;

// number of connected components in the graph
public class ConnectedComponent {
    private final boolean[] marked;
    private final int[] size;
    private int count;

    public ConnectedComponent(Graph graph) {
        marked = new boolean[graph.V()];
        size = new int[graph.V()];

        for (int i = 0; i < graph.V(); i++) {
            if (!marked[i]) {
                count++;
                dfs(graph, i);
            }
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        size[count]++;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    public int count() {
        return this.count;
    }

    public static void main(String[] args) {
        Graph graph = getGraph();
        ConnectedComponent cc = new ConnectedComponent(graph);
        System.out.println(cc.count);
        System.out.println(Arrays.toString(cc.size));
    }
}
