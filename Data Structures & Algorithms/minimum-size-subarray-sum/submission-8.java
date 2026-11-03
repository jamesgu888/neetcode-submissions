class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int length = 0;
        int sum = 0;
        int lastIdx = 0;

        for (int num : nums) {
            sum += num;
            length++;

            while (sum >= target) {
                minLength = Math.min(minLength, length);

                sum -= nums[lastIdx];
                lastIdx++;
                length--;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}