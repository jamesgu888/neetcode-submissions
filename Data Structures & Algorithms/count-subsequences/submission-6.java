class Solution {
    public int numDistinct(String s, String t) {
        int[][] memo = new int[s.length()][t.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(s, t, 0, 0, memo);
    }

    private int dfs(String s, String t, int sIndex, int tIndex, int[][] memo) {
        if (tIndex >= t.length()) {
            return 1;
        }
        
        if (sIndex >= s.length()) {
            return 0;
        }

        if (memo[sIndex][tIndex] != -1) {
            return memo[sIndex][tIndex];
        }

        boolean matches = s.charAt(sIndex) == t.charAt(tIndex);

        memo[sIndex][tIndex] = dfs(s, t, sIndex + 1, tIndex, memo); // case 1: skip current character

        if (matches) {
            memo[sIndex][tIndex] += dfs(s, t, sIndex + 1, tIndex + 1, memo); // case 2: if matches, take it and continue matching
        }

        return memo[sIndex][tIndex];
    }
}
