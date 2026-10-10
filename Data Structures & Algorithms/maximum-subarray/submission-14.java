class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            sum = Math.max(num, sum + num);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
