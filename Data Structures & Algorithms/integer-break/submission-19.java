class Solution {
    public int integerBreak(int n) {
        int[] memo = new int[n];
        return dfs(n, memo);
    }

    private int dfs(int n, int[] memo) {
        if (n <= 2) {
            return 1;
        }

        if (memo[n - 1] != 0) {
            return memo[n - 1];
        }

        int best = Integer.MIN_VALUE;
        for (int i = 1; i <= n / 2; i++) {
            int product = i * Math.max(n - i, dfs(n - i, memo));
            best = Math.max(best, product);
        }

        memo[n - 1] = best;
        return memo[n - 1];
    }
}