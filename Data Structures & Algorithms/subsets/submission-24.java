class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> cur, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList(cur));
            return;
        }

        // case 1: take number
        cur.add(nums[i]);
        dfs(nums, i + 1, cur, res);

        // case 2: skip number
        cur.remove(cur.size() - 1);
        dfs(nums, i + 1, cur, res);
    }
}
