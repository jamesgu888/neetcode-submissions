class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int n, int k, int start, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() >= k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start + 1; i <= n; i++) {
            cur.add(i);
            dfs(n, k, i, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}

