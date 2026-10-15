class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, 0, 0, "", res);
        return res;
    }

    private void dfs(int n, int open, int close, String s, List<String> res) {
        if (open == n && close == n) {
            res.add(s);
            return;
        }

        if (open < n) {
            dfs(n, open + 1, close, s + "(", res);
        }

        if (close < open) {
            dfs(n, open, close + 1, s + ")", res);
        }
    }
}
