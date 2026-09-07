class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int leftPtr = m - 1;
        int rightPtr = n - 1;
        int idx = nums1.length - 1;

        while (leftPtr >= 0 && rightPtr >= 0) {
            if (nums1[leftPtr] >= nums2[rightPtr]) {
                nums1[idx] = nums1[leftPtr];
                leftPtr--;
            } else {
                nums1[idx] = nums2[rightPtr];
                rightPtr--;
            }

            idx--;
        }

        while (leftPtr >= 0) {
            nums1[idx] = nums1[leftPtr];
            leftPtr--;
            idx--;
        }

        while (rightPtr >= 0) {
            nums1[idx] = nums2[rightPtr];
            rightPtr--;
            idx--;
        }
    }
}