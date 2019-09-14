package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  Topological sort using reversed postorder of graph(DFS).
 *
 */
public class TopologicalSortII {
    private final boolean[] marked;
    private final Stack<Integer> post;
    private final List<Integer>[] adj;

    public TopologicalSortII(int n, int[][] edges) {
        marked = new boolean[n];
        post = new Stack<>();

        // initialize adjacency list
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        // construct adjacency list
        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(edges[i][1]);
        }

        for (int i = 0; i < n; i++) {
            if (!marked[i]) dfs(i);
        }
    }

    private void dfs(int v) {
        marked[v] = true;

        for (int w : adj[v]) {
            if (!marked[w]) {
                dfs(w);
            }
        }
        post.push(v);
    }

    public Iterable<Integer> order() {
        return post;
    }

    private static int[][] constructEdges() {
        return new int[][]{{0,1}, {1,2}, {1,4}, {1,5}, {5,2}, {5,9}, {2,3},{2,8}, {3,6}, {6,7}, {6,9}};
    }

    public static void main(String[] args) {
        TopologicalSortII topologicalSort = new TopologicalSortII(10, constructEdges());
        for (int v : topologicalSort.order()) {
            System.out.print(v + "  ");
        }
    }
}
