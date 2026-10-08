class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        boolean even = nums.length % 2 == 0;

        for (int i = 0; i < nums.length; i++) {
            if (i < nums1.length) {
                nums[i] = nums1[i];
            } else {
                nums[i] = nums2[i - nums1.length];
            }
        }

        Arrays.sort(nums);

        return (even) ? ((double) nums[(nums.length - 1) / 2] + nums[nums.length / 2]) / 2 : nums[nums.length / 2];
    }
}
