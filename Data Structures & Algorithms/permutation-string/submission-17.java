class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        } 

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < freq1.length; i++) {
            if (freq1[i] == freq2[i]) {
                matches++;
            }
        }

        if (matches == 26) {
            return true;
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            char add = s2.charAt(r);

            freq2[add - 'a']++;
            if (freq1[add - 'a'] == freq2[add - 'a']) {
                matches++;
            } else if (freq1[add - 'a'] + 1 == freq2[add - 'a']) {
                matches--;
            }

            char remove = s2.charAt(l);

            freq2[remove - 'a']--;
            if (freq1[remove - 'a'] == freq2[remove - 'a']) {
                matches++;
            } else if (freq1[remove - 'a'] == freq2[remove - 'a'] + 1) {
                matches--;
            }

            l++;
            if (matches == 26) {
                return true;
            }
        }
        
        return false;
    }
}
