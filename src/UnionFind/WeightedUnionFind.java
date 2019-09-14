package UnionFind;

/**
 *  Union Find:
 *  find:  O(logn)
 *  union: O(logn)
 *
 */
public class WeightedUnionFind {
    private int[] id;

    public WeightedUnionFind(int n) {
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
