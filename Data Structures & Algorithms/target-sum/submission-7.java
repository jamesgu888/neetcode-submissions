class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += Math.abs(num);
        }

        int[][] memo = new int[nums.length][totalSum * 2 + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(nums, 0, target, memo, totalSum);
    }

    private int dfs(int[] nums, int i, int target, int[][] memo, int totalSum) {
        if (target > totalSum || target < -totalSum) {
            return 0;
        }
        
        if (i >= nums.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (memo[i][target + totalSum] != -1) {
            return memo[i][target + totalSum];
        }

        int total = 0;
        total += dfs(nums, i + 1, target - nums[i], memo, totalSum); // add number
        total += dfs(nums, i + 1, target + nums[i], memo, totalSum); // minus number

        memo[i][target + totalSum] = total;
        return memo[i][target + totalSum];
    }
}
