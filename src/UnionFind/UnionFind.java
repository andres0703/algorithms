package UnionFind;

/**
 *  Union Find:
 *  find:  O(n)
 *  union: O(n)
 *
 */
public class UnionFind {
    private int[] id;

    public UnionFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    // change root of b to root of a
    public void union(int a, int b) {
        int rootA = root(a);
        int rootB = root(b);

        id[rootB] = rootA;
    }

    public boolean isConnected(int a, int b) {
        return root(a) == root(b);
    }

    // number of connected component
    public int count() {
        int count = 0;
        for (int i = 0; i < id.length; i++) {
            if (i == id[i]) count++;
        }
        return count;
    }

    public int find(int a) {
        return root(a);
    }

    private int root(int a) {
        while (a != id[a]) {
            a = id[a];
        }
        return a;
    }
}
