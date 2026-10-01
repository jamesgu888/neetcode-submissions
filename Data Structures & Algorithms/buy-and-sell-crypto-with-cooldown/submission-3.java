class Solution {
    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int res = dfs(prices, 0, false, memo);
        return res;
    }

    private int dfs(int[] prices, int i, boolean hasCoin, int[][] memo) {
        if (i >= prices.length) {
            return 0;
        }

        int state = (hasCoin) ? 1 : 0;

        if (memo[i][state] != -1) {
            return memo[i][state];
        }

        int case1 = 0;
        int case2 = 0;
        int case3 = 0;

        if (hasCoin) {
            case1 = prices[i] + dfs(prices, i + 2, false, memo); // if have coin, sell
        }

        if (!hasCoin) {
            case1 = -prices[i] + dfs(prices, i + 1, true, memo); // if dont have coin, buy
        }

        case3 = dfs(prices, i + 1, hasCoin, memo); // skip this day

        memo[i][state] = Math.max(case1, Math.max(case2, case3));
        return memo[i][state];
    }
}
