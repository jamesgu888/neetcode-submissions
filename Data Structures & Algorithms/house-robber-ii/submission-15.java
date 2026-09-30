class Solution {
    public int rob(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }

        
        return Math.max(dfs(nums, 0, nums.length - 1), dfs(nums, 1, nums.length));
    }

    private int dfs(int[] nums, int start, int end) {
        int oneHouseBack = 0;
        int twoHouseBack = 0;

        for (int i = start; i < end; i++) {
            int cur = Math.max(oneHouseBack, nums[i] + twoHouseBack);

            twoHouseBack = oneHouseBack;
            oneHouseBack = cur;
        }

        return oneHouseBack;
    }
}
