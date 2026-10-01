class Solution {
    public int[] productExceptSelf(int[] nums) {
        int total = 1, zeroes = 0;

        for (int num : nums) {
            if (num == 0) {
                zeroes++;
            } else {
                total *= num;
            }
        }

        if (zeroes > 1) {
            return new int[nums.length];
        }

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res[i] = total;
            } else if (zeroes == 1) {
                res[i] = 0;
            } else {
                res[i] = total / nums[i];
            }
        }

        return res;
    }
}  
