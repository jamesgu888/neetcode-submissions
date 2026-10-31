class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return dfs(s, wordDict, 0, memo);
    }

    private boolean dfs(String s, List<String> wordDict, int i, int[] memo) {
        if (memo[i] != -1) {
            return (memo[i] == 1) ? true : false;
        }

        if (i >= s.length()) {
            return true;
        }

        for (String word : wordDict) {
            int length = word.length();

            if (i + length > s.length()) {
                continue;
            }

            String substring = s.substring(i, i + length);

            if (substring.equals(word) && dfs(s, wordDict, i + length, memo)) {
                memo[i] = 1;
                return true;
            }
        }

        memo[i] = 0;
        return false;
    }
}
