class Solution {
    public int removeElement(int[] nums, int val) {
        int swapIdx = 0;
        int res = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[swapIdx] = nums[i];
                swapIdx++;
                res++;
            }
        }

        return res;
    }
}