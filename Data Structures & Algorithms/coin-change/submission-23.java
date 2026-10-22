class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int res = dfs(coins, coins.length - 1, amount, memo);
        return (res >= 99999) ? -1 : res;
    }

    private int dfs(int[] coins, int i, int amount, int[][] memo) {
        if (i < 0 || amount < 0) {
            return 99999;
        }

        if (amount == 0) {
            return 0;
        }

        if (memo[i][amount] != -1) {
            return memo[i][amount];
        }

        if (coins[i] > amount) {
            return memo[i][amount] = dfs(coins, i - 1, amount, memo);
        }

        // case 1: take a coin
        int case1 = 1 + dfs(coins, i, amount - coins[i], memo);

        // case 2: skip the coin
        int case2 = dfs(coins, i - 1, amount, memo);

        return memo[i][amount] = Math.min(case1, case2);
    }
}
