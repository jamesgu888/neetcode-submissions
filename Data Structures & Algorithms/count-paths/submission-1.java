class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }

        return dfs(0, 0, m, n, cache);
    }

    private int dfs(int r, int c, int m, int n, int[][] cache) {
        if (r == m - 1 && c == n - 1) {
            return 1;
        }

        if (r > m - 1 || c > n - 1) {
            return 0;
        }

        if (cache[r][c] != -1) {
            return cache[r][c];
        }

        cache[r][c] = dfs(r + 1, c, m, n, cache) + dfs(r, c + 1, m, n, cache);
        return cache[r][c];
    }
}
