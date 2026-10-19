class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int i = 0;

        while (i <= maxReach) {
            if (maxReach >= nums.length - 1) {
                return true;
            }

            maxReach = Math.max(maxReach, i + nums[i]);
            i++;
        }

        return false;
    }
}
