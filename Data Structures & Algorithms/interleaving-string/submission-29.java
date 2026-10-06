class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return dfs(s1, s2, s3, 0, 0, 0, new Boolean[s1.length() + 1][s2.length() + 1]);
    }

    private boolean dfs(String s1, String s2, String s3, int s1Ptr, int s2Ptr, int s3Ptr, Boolean[][] memo) {
        if (s3Ptr == s3.length()) {
            memo[s1Ptr][s2Ptr] = true;
            return memo[s1Ptr][s2Ptr];
        }

        if (memo[s1Ptr][s2Ptr] != null) {
            return memo[s1Ptr][s2Ptr];
        }

        boolean match1 = s1Ptr < s1.length() && s1.charAt(s1Ptr) == s3.charAt(s3Ptr);
        boolean match2 = s2Ptr < s2.length() && s2.charAt(s2Ptr) == s3.charAt(s3Ptr);
        boolean res = false;

        if (match1 && match2) {
            res = dfs(s1, s2, s3, s1Ptr + 1, s2Ptr, s3Ptr + 1, memo) || dfs(s1, s2, s3, s1Ptr, s2Ptr + 1, s3Ptr + 1, memo);
        } else if (match1) {
            res = dfs(s1, s2, s3, s1Ptr + 1, s2Ptr, s3Ptr + 1, memo);
        } else if (match2) {
            res = dfs(s1, s2, s3, s1Ptr, s2Ptr + 1, s3Ptr + 1, memo);
        }

        memo[s1Ptr][s2Ptr] = res;
        return memo[s1Ptr][s2Ptr];
    }
}
