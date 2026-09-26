class Solution {
    public int missingNumber(int[] nums) {
        int[] list = new int[nums.length + 1];

        for (int num : nums) {
            list[num] = 1;
        }

        for (int i = 0; i < list.length; i++) {
            if (list[i] != 1) {
                return i;
            }
        }

        return -1;
    }
}
