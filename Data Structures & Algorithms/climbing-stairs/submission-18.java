class Solution {
    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }

        int[] dp = {2, 3};
        for (int i = 4; i <= n; i++) {
            int tmp = dp[1];
            dp[1] = dp[0] + dp[1];
            dp[0] = tmp;
        }

        return dp[1];
    }
}
