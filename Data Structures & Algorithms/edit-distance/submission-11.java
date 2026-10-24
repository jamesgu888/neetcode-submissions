class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(word1, word2, 0, 0, memo);
    }

    private int dfs(String word1, String word2, int ptr1, int ptr2, int[][] memo) {
        if (ptr1 == word1.length()) {
            return word2.length() - ptr2;
        }

        if (ptr2 == word2.length()) {
            return word1.length() - ptr1;
        }

        if (memo[ptr1][ptr2] != -1) {
            return memo[ptr1][ptr2];
        }

        // case 1: characters match
        int case1 = Integer.MAX_VALUE;
        if (word1.charAt(ptr1) == word2.charAt(ptr2)) {
            case1 = dfs(word1, word2, ptr1 + 1, ptr2 + 1, memo);
        }

        // case 2: characters don't match
        int case2 = Integer.MAX_VALUE;
        if (word1.charAt(ptr1) != word2.charAt(ptr2)) {
            case2 = 1 + Math.min(dfs(word1, word2, ptr1, ptr2 + 1, memo), Math.min(dfs(word1, word2, ptr1 + 1, ptr2, memo), dfs(word1, word2, ptr1 + 1, ptr2 + 1, memo)));
        }

        return memo[ptr1][ptr2] = Math.min(case1, case2);
    }
}
