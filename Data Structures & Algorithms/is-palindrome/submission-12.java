class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();

        while (right - left + 1 >= 2) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && right - left + 1 >= 2) {
                left++;
            }

            while(!Character.isLetterOrDigit(s.charAt(right)) && right - left + 1 >= 2) {
                right--;
            }

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
