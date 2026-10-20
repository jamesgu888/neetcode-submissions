class Solution {
    public int splitArray(int[] nums, int k) {
        int[][] memo = new int[nums.length][k];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(nums, 0, k - 1, memo);
    }

    private int dfs(int[] nums, int i, int remaining, int[][] memo) {
        if (remaining == 0) {
            int sum = 0;
            
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
            }

            return sum;
        }

        if (memo[i][remaining] != -1) {
            return memo[i][remaining];
        }

        int min = Integer.MAX_VALUE;
        for (int j = i + 1; j < nums.length; j++) {
            int sum = 0;
            
            for (int k = i; k < j; k++) {
                sum += nums[k];
            }

            int res = dfs(nums, j, remaining - 1, memo);
            min = Math.min(min, Math.max(sum, res));
        }

        memo[i][remaining] = min;
        return memo[i][remaining];
    }
}