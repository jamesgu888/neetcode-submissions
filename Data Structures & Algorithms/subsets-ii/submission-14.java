class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res, new HashSet<>());
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> cur, List<List<Integer>> res, Set<List<Integer>> visited) {
        List<Integer> sorted = new ArrayList(cur);
        Collections.sort(sorted);
        if (!visited.contains(sorted)) {
            res.add(new ArrayList(cur));
            visited.add(sorted);
        }

        for (int j = i; j < nums.length; j++) {
            cur.add(nums[j]);
            dfs(nums, j + 1, cur, res, visited);
            cur.remove(cur.size() - 1);
        }
    }
}
