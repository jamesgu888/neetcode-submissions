class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(0, memo, nums);
    }

    private int dfs(int i, int[] memo, int[] nums) {
        if (i >= nums.length) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        memo[i] = Math.max(dfs(i + 1, memo, nums), nums[i] + dfs(i + 2, memo, nums));
        return memo[i];
    }
}
