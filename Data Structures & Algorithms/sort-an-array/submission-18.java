class Solution {
    public int[] sortArray(int[] nums) {
        int lastParent = nums.length / 2 - 1;
        while (lastParent >= 0) {
            bubbleDown(nums, nums.length, lastParent);
            lastParent--;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;

            bubbleDown(nums, i, 0);
        }

        return nums;
    }

    private void bubbleDown(int[] nums, int n, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;

        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }

        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != i) {
            int tmp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = tmp;

            bubbleDown(nums, n, largest);
        }
    }
}