class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = Math.max(area, findArea(grid, i, j));
                }
            }
        }
        
        return area;
    }

    private int findArea(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r > grid.length - 1 || c > grid[0].length - 1 || grid[r][c] == 0) {
            return 0;
        }

        int count = 1;
        grid[r][c] = 0;

        for (int[] dir : directions) {
            count += findArea(grid, r + dir[0], c + dir[1]);
        }

        return count;
    }
}
