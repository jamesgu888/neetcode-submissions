class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    deleteIsland(grid, i, j);
                }
            }
        }

        return count;
    }

    private void deleteIsland(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (r < 0 || c < 0 || r > grid.length - 1 || c > grid[0].length - 1 || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        deleteIsland(grid, r + 1, c);
        deleteIsland(grid, r - 1, c);
        deleteIsland(grid, r, c + 1);
        deleteIsland(grid, r, c - 1);

        return;
    }
}
