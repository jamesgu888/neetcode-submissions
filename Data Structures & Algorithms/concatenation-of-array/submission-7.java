class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        ArrayList<Integer> tmp = new ArrayList<>();

        for (int num : nums) {
            tmp.add(num);
        }

        for (int num : nums) {
            tmp.add(num);
        }

        for (int i = 0; i < tmp.size(); i++) {
            ans[i] = tmp.get(i);
        }

        return ans;
    }
}