class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, i);
            right++;
            max = Math.max(max, right - left);
        }

        return max;
    }
}
