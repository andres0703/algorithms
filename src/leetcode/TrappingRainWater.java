package leetcode;

class TrappingRainWater {
    public int trapRainWater(int[][] map) {
        if (map.length <= 2 || map[0].length <= 2) return 0;

        int m = map.length, n = map[0].length;
        int res = 0;

        int[][] left  = new int[m][n];  // maximum for far from left
        int[][] right = new int[m][n];
        int[][] front = new int[m][n];
        int[][] back  = new int[m][n];

        int maxA = 0;
        int maxB = 0;
        for (int i = 0; i < m; i++) {
            maxA = 0; maxB = 0;
            for (int j = 0; j < n; j++) {
                maxA = Math.max(maxA, map[i][j]);
                maxB = Math.max(maxB, map[i][n - 1 - j]);
                left[i][j] = maxA;
                right[i][n - 1 - j] = maxB;
            }
        }

        maxA = 0;
        maxB = 0;
        for (int i = 0; i < n; i++) {
            maxA = 0; maxB = 0;
            for (int j = 0; j < m; j++) {
                maxA = Math.max(maxA, map[j][i]);
                maxB = Math.max(maxB, map[m - 1 - j][i]);
                front[j][i] = maxA;
                back[m - 1 - j][i] = maxB;
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int l = left[i][j], r = right[i][j];
                int f = front[i][j], b = back[i][j];
                System.out.println(l + ", " + r + ", " + f + ", " + b);
                res += Math.min(Math.min(l, r), Math.min(f, b)) - map[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] map = new int[][] {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        TrappingRainWater t = new TrappingRainWater();
        System.out.println(t.trapRainWater(map));
    }
}