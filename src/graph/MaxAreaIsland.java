package graph;

public class MaxAreaIsland {

    static Integer area = 0;

    public static int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    area = Math.max(area, maxAreaOfIsland(grid, i, j));
                    count++;
                }

            }

        }

        return area;
    }

    static int maxAreaOfIsland(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return 0;
        }

        grid[i][j] = '0'; //visited

        return 1 + maxAreaOfIsland(grid, i + 1, j) +
                maxAreaOfIsland(grid, i - 1, j) +
                maxAreaOfIsland(grid, i, j + 1) +
                maxAreaOfIsland(grid, i, j - 1);   // like the tree depth
    }


    public static void main(String[] args) {

        char grid[][] = {
                {
                        '1', '1', '1', '1', '0'
                },
                {
                        '1', '1', '0', '1', '0'
                },
                {
                        '1', '1', '0', '0', '0'
                },
                {
                        '0', '0', '0', '0', '1'
                }
        };

        System.out.println(numIslands(grid));
        System.out.println(area);

    }
}
