package basic_algorithms;

/*

Given a matrix of N*M order. Find the shortest distance from a source cell to a destination cell,
traversing through limited cells only. Also you can move only up, down, left and right.
If found output the distance else -1.

s represents ‘source’
d represents ‘destination’
* represents cell you can travel
0 represents cell you can not travel
This problem is meant for single source and destination.

 */

import java.util.LinkedList;
import java.util.Queue;

// use breadth first search
public class ShortestDistanceInGraph {

    public static int shortest(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int source = 0;
        int destination = 0;

        // target source and destination
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 's') {
                    source = i * n + j;
                } else if (grid[i][j] == 'd') {
                    destination = i * n + j;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int cell = queue.poll();

                // if reached destination, just break out of the loop
                if (cell == destination) {
                    break;
                }

                int r = cell / n;
                int c = cell % n;

                checkCell(grid, queue, r - 1, c);
                checkCell(grid, queue, r + 1, c);
                checkCell(grid, queue, r, c - 1);
                checkCell(grid, queue, r, c + 1);

                size--;
            }
            dist++;
        }
        return dist;
    }

    private static void checkCell(char[][] grid, Queue<Integer> queue, int r, int c) {
        // out of bound
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return;
        }

        char ch = grid[r][c];
        if (ch == 's' || ch == 'd' || ch == '0') {
            return;
        }

        // if it's valid, add it to the queue
        if (ch == '*') {
            queue.add(r * grid[0].length + c);
            grid[r][c] = '0';
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'d', '0', 's', '*'},
                         {'*', '0', '*', '*'},
                         {'*', '0', '0', '*'},
                         {'*', '*', '*', '*'}};
        System.out.println(shortest(grid));
    }
}
