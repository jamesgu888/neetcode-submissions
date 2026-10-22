class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList(cur));

        for (int j = i; j < nums.length; j++) {
            cur.add(nums[j]);
            dfs(nums, j + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
