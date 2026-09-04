class Solution {
    public int[] getConcatenation(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        nums = new int[nums.length * 2];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }

        return nums;
    }
}