class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dfs(nums, i, memo));
        }

        return max;
    }

    private int dfs(int[] nums, int start, int[] memo) {
        if (start >= nums.length) {
            return 0;
        }

        if (memo[start] != 0) {
            return memo[start];
        }

        int max = 1;
        for (int i = start + 1; i < nums.length; i++) {
            if (nums[i] > nums[start]) {
                max = Math.max(max, 1 + dfs(nums, i, memo));
            }
        }

        memo[start] = max;
        return memo[start];
    }
}
