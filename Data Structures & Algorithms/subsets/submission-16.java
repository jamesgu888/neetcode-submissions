class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        
        subsetsHelper(nums, 0, res, cur);
        return res;
    }

    public void subsetsHelper(int[] nums, int idx, List<List<Integer>> res, List<Integer> cur) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[idx]);
        subsetsHelper(nums, idx + 1, res, cur);
        cur.remove(cur.size() - 1);
        subsetsHelper(nums, idx + 1, res, cur);
    }

}
