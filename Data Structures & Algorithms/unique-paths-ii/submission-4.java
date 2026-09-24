class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] cache = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }

        return dfs(0, 0, obstacleGrid, cache);
    }

    private int dfs(int r, int c, int[][] obstacleGrid, int[][] cache) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        if (r > rows - 1 || c > cols - 1 || obstacleGrid[r][c] == 1) {
            return 0;
        }

        if (r == rows - 1 && c == cols - 1) {
            return 1;
        }

        if (cache[r][c] != -1) {
            return cache[r][c];
        }

        cache[r][c] = dfs(r + 1, c, obstacleGrid, cache) + dfs(r, c + 1, obstacleGrid, cache);
        return cache[r][c];
    }
}