package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TheMaze {
    private static final List<int[]> DIRECTION = Arrays.asList(
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{0, 1}
    );

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0) return false;
        int m = maze.length, n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.add(start);

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            System.out.println(r + ", " + c);

            // arrive at the destination
            if(r == destination[0] && c == destination[1]) {
                return true;
            }

            visited[r][c] = true;

            for (int[] dir : DIRECTION) {
                int r2 = r, c2 = c;
                // move until hit a wall
                while (isValid(maze, r2 += dir[0], c2 += dir[1])) {}
                // move back one slot
                r2 -= dir[0];
                c2 -= dir[1];

                if (!visited[r2][c2]) {
                    queue.offer(new int[]{r2, c2});
                }
            }
        }
        return false;
    }

    private boolean isValid(int[][] maze, int r, int c) {
        return r >= 0 && c >= 0 && r < maze.length && c < maze[0].length && maze[r][c] == 0;
    }

    public static void main(String[] args) {
        TheMaze app = new TheMaze();
        int[][] maze = new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1,},{0,0,0,0,0}};
        app.hasPath(maze, new int[]{0,4}, new int[]{4,4});
    }
}