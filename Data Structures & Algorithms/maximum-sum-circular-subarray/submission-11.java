class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            sum = Math.max(num, sum + num);
            maxSum = Math.max(maxSum, sum);
        }

        sum = nums[0];
        int minSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            sum = Math.min(num, sum + num);
            minSum = Math.min(minSum, sum);
        }

        int total = 0;
        
        for (int num : nums) {
            total += num;
        }

        if (maxSum < 0) {
            return maxSum;
        }
        return Math.max(maxSum, total - minSum);
    }
}