class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int curOnes = 0;

        for (int num : nums) {
            if (num == 1) {
                curOnes++;
            } else {
                curOnes = 0;
            }

            if (curOnes > maxOnes) {
                maxOnes = curOnes;
            }
        }

        return maxOnes;
    }
}