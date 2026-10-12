class Solution {
    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(prices, 0, 0, memo);
    }

    private int dfs(int[] prices, int i, int hasStock, int[][] memo) {
        if (i >= prices.length) {
            return 0;
        }

        if (memo[i][hasStock] != -1) {
            return memo[i][hasStock];
        }

        // case 1: skip day
        int case1 = dfs(prices, i + 1, hasStock, memo);

        // case 2: if don't have stock, buy stock
        int case2 = 0;
        if (hasStock == 0) {
            case2 = -prices[i];
            case2 += dfs(prices, i + 1, 1, memo);
        }

        // case 3: if have stock, sell stock
        int case3 = 0;
        if (hasStock == 1) {
            case3 = prices[i];
            case3 += dfs(prices, i + 1, 0, memo);
        }

        memo[i][hasStock] = Math.max(case1, Math.max(case2, case3));
        return memo[i][hasStock];
    }
}