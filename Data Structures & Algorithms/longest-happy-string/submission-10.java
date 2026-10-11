class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();

        while ((a + b + c) > 0) {
            char ch = '0';

            if (res.length() >= 2 && res.charAt(res.length() - 2) == res.charAt(res.length() - 1)) {
                if (res.charAt(res.length() - 1) == 'a') {
                    if (b > 0) {
                        ch = 'b';
                        b--;
                    } else if (c > 0) {
                        ch = 'c';
                        c--;
                    } else {
                        break;
                    }
                } else if (res.charAt(res.length() - 1) == 'b') {
                    if (a > 0) {
                        ch = 'a';
                        a--;
                    } else if (c > 0) {
                        ch = 'c';
                        c--;
                    } else {
                        break;
                    }
                } else if (res.charAt(res.length() - 1) == 'c') {
                    if (a > 0) {
                        ch = 'a';
                        a--;
                    } else if (b > 0) {
                        ch = 'b';
                        b--;
                    } else {
                        break;
                    }
                }
            } else if (a >= b && a >= c) {
                ch = 'a';
                a--;
            } else if (b >= c) {
                ch = 'b';
                b--;
            } else {
                ch = 'c';
                c--;
            }

            res.append(ch);
        }

        return res.toString();
    }
}