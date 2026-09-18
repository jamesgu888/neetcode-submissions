class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        backtrack(nums, 0, target, res, cur);
        return res;
    }

    public void backtrack(int[] nums, int idx, int target, List<List<Integer>> res, List<Integer> cur) {
        if (target < 0 || idx == nums.length) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[idx]);
        target -= nums[idx];
        backtrack(nums, idx, target, res, cur);     // case where we add and repeat

        cur.remove(cur.size() - 1);
        target += nums[idx];
        backtrack(nums, idx + 1, target, res, cur); // case where we skip
    }
}
