class Solution {
    public int coinChange(int[] coins, int amount) {
        int res = dfs(coins, coins.length - 1, amount, 0);
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    private int dfs(int[] coins, int i, int amount, int count) {
        if (amount == 0) {
            return count;
        }

        if (i < 0 || amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (coins[i] > amount) {
            return dfs(coins, i - 1, amount, count);
        }

        // case 1: take a coin
        int case1 = dfs(coins, i, amount - coins[i], count + 1);

        // case 2: skip the coin
        int case2 = dfs(coins, i - 1, amount, count);

        return Math.min(case1, case2);
    }
}
