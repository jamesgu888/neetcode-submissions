class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxFreq = 0, best = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));

            while (right - left + 1 - maxFreq > k) {
                char outgoing = s.charAt(left);
                map.put(outgoing, map.get(outgoing) - 1);
                left++;
            }

            best = Math.max(best, right - left + 1);
        }

        return best;
    }
}
