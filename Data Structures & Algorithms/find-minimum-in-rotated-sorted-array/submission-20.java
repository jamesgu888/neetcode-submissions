class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            System.out.println("l: " + nums[l] + ", r: " + nums[r]);

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[r];
    }
}

// 3, 4, 5, 6, 1, 2

// 6, 1, 2, 3, 4, 5

// 1, 2, 3, 4, 5, 6