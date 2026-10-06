class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        return helper(s1, s2, s3, new HashMap<>());
    }

    private boolean helper(String s1, String s2, String s3, Map<String, Boolean> memo) {
        String key = s1 + "|" + s2 + "|" + s3;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int s1Ptr = 0;
        int s2Ptr = 0;
        int s3Ptr = 0;

        while (s3Ptr < s3.length()) {
            boolean match1 = s1Ptr < s1.length() && s1.charAt(s1Ptr) == s3.charAt(s3Ptr);
            boolean match2 = s2Ptr < s2.length() && s2.charAt(s2Ptr) == s3.charAt(s3Ptr);

            if (match1 && match2) {
                boolean res = helper(s1.substring(s1Ptr + 1), s2.substring(s2Ptr), s3.substring(s3Ptr + 1), memo) || 
                helper(s1.substring(s1Ptr), s2.substring(s2Ptr + 1), s3.substring(s3Ptr + 1), memo);

                memo.put(key, res);
                return res;
            } else if (match1) {
                s1Ptr++;
            } else if (match2) {
                s2Ptr++;
            } else {
                memo.put(key, false);
                return false;
            }

            s3Ptr++;
        }

        memo.put(key, true);
        return true;
    }
}
