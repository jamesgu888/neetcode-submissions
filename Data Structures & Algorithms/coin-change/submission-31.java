class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -2);
        }

        return dfs(coins, coins.length - 1, amount, memo);
    }

    private int dfs(int[] coins, int i, int amount, int[][] memo) {
        if (i < 0 || amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (memo[i][amount] != -2) {
            return memo[i][amount];
        }

        if (coins[i] > amount) {
            return memo[i][amount] = dfs(coins, i - 1, amount, memo);
        }

        // case 1: take a coin
        int tmp = dfs(coins, i, amount - coins[i], memo);
        int case1 = (tmp == -1) ? -1 : 1 + tmp;

        // case 2: skip the coin
        int case2 = dfs(coins, i - 1, amount, memo);

        if (case1 == -1 && case2 == -1) {
            memo[i][amount] = -1;
        } else if (case1 == -1 || case2 == -1) {
            memo[i][amount] = Math.max(case1, case2);
        } else {
            memo[i][amount] = Math.min(case1, case2);
        }
        return memo[i][amount];
    }
}
