class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return answer(nums1, nums2);
        } else {
            return answer(nums2, nums1);
        }
    }

    private double answer(int[] small, int[] big) {
        int l = 0;
        int r = small.length;
        int leftSize = (small.length + big.length + 1) / 2;
        int smallPartition = 0;
        int bigPartition = 0;
        int smallLeft = 0;
        int smallRight = 0;
        int bigLeft = 0;
        int bigRight = 0;

        while (l <= r) {
            smallPartition = l + (r - l) / 2;
            bigPartition = leftSize - smallPartition;

            smallLeft = (smallPartition == 0) ? Integer.MIN_VALUE : small[smallPartition - 1];
            smallRight = (smallPartition == small.length) ? Integer.MAX_VALUE : small[smallPartition];
            bigLeft = (bigPartition == 0) ? Integer.MIN_VALUE : big[bigPartition - 1];
            bigRight = (bigPartition == big.length) ? Integer.MAX_VALUE : big[bigPartition];

            if (smallLeft > bigRight) {
                r = smallPartition - 1;
            } else if (bigLeft > smallRight) {
                l = smallPartition + 1;
            } else {
                break;
            }
        }

        if ((small.length + big.length) % 2 != 0) {
            return Math.max(smallLeft, bigLeft);
        } else {
            double one = Math.max(smallLeft, bigLeft);
            double two = Math.min(smallRight, bigRight);
            return (one + two) / 2;
        }
    }
}
