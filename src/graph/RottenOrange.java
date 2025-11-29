package graph;

import java.util.LinkedList;
import java.util.Queue;
// BFSSSS
// time complexity O(m*n)
public class RottenOrange {

    int minute = 0;

    public int orangesRotting(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < m; i += 1) {
            for (int j = 0; j < n; j += 1) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j}); //  add rotten orange to queue
                } else if (grid[i][j] == 1) {
                    fresh += 1; // how many fresh oranges
                }
            }
        }

        int count = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // directions

        while (!queue.isEmpty() && fresh != 0) {


            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] rotten = queue.poll();
                int r = rotten[0], c = rotten[1];
                for (int[] dir : dirs) {
                    int x = r + dir[0], y = c + dir[1];
                    if (0 <= x && x < m && 0 <= y && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y}); // the new rottennnn
                        fresh -= 1;
                    }
                }
            }

            count += 1; // icrement time count

        }


        return fresh == 0 ? count : -1;
    }
}

