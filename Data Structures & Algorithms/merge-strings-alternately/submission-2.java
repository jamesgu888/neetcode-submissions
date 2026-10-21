class Solution {
    public String mergeAlternately(String word1, String word2) {
        String res = "";
        int i = 0;
        int j = 0;
        boolean turn = true;

        while (i < word1.length() && j < word2.length()) {
            if (turn) {
                res += word1.charAt(i);
                i++;
            } else {
                res += word2.charAt(j);
                j++;
            }

            turn = !turn;
        }

        while (i < word1.length()) {
            res += word1.charAt(i);
            i++;
        }

        while (j < word2.length()) {
            res += word2.charAt(j);
            j++;
        }

        return res;
    }
}