class Solution {
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;

            while (j > 0 && nums[j - 1] > nums[j]) {
                int tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = tmp;

                j--;
            }
        }

        return nums;
    }
}