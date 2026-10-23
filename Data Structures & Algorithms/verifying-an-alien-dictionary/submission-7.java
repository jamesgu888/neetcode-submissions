class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];

        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);

            map[c - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            boolean foundDiff = false;

            for (int j = 0; j < word1.length() && j < word2.length(); j++) {
                if (map[word1.charAt(j) - 'a'] < map[word2.charAt(j) - 'a']) {
                    foundDiff = true;
                    break;
                } else if (map[word1.charAt(j) - 'a'] > map[word2.charAt(j) - 'a']) {
                    return false;
                }
            }

            if (!foundDiff && word1.length() > word2.length()) {
                return false;
            }
        }

        return true;
    }
}