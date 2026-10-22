class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // build to s1 length
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            
            freq1[c - 'a'] = freq1[c - 'a'] + 1;
        }

        // sliding window
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);

            if (i >= s1.length()) {
                char remove = s2.charAt(i - s1.length());

                freq2[remove - 'a'] = freq2[remove - 'a'] - 1;
            }

            System.out.println(Arrays.toString(freq2));

            freq2[c - 'a'] = freq2[c - 'a'] + 1;
            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }
}
