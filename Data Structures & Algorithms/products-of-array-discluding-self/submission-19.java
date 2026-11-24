class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        int[] postfix = new int[nums.length];
        postfix[nums.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i + 1];
        }
        
        int[] res = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix[i] * postfix[i];
        }

        return res;
    }
}  

// 1, 1, 2, 8
// 48, 24, 6, 1