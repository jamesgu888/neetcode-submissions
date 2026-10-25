class Solution {
    public int tribonacci(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(n, memo);
    }

    private int dfs(int n, int[] memo) {
        if (n <= 2) {
            return (n == 0) ? 0 : 1;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        return memo[n] = dfs(n - 1, memo) + dfs(n - 2, memo) + dfs(n - 3, memo);
    }
}