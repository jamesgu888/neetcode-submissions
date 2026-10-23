class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
                res = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }

        return res;
    }
}