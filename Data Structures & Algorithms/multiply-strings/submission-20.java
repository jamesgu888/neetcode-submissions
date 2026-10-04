class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        String res = "";
        String zeroes = "";

        for (int i = num2.length() - 1; i >= 0; i--) {
            String total = multiplyOneDigit(num1, num2.substring(i, i + 1));

            res = add(res, total + zeroes);
            zeroes += "0";
        }

        return res;
    }

    private String add(String num1, String num2) {
        StringBuilder string = new StringBuilder();
        int carry = 0;
        int length1 = num1.length();
        int length2 = num2.length();

        while (length1 > 0 || length2 > 0) {
            int total = carry;

            if (length1 > 0) {
                total += num1.charAt(length1 - 1) - '0';
                length1--;
            }

            if (length2 > 0) {
                total += num2.charAt(length2 - 1) - '0';
                length2--;
            }

            string.insert(0, total % 10);
            carry = total / 10;
        }

        if (carry > 0) {
            string.insert(0, carry);
        }

        return string.toString();
    }

    private String multiplyOneDigit(String num1, String num2) {
        if (num2.length() != 1) {
            return "";
        }

        StringBuilder string = new StringBuilder();
        int carry = 0;
        
        for (int i = num1.length() - 1; i >= 0; i--) {
            int num1Digit = num1.charAt(i) - '0';
            int num2Digit = num2.charAt(0) - '0';
            int num = num1Digit * num2Digit + carry;
            carry = num / 10;

            string.insert(0, num % 10);
        }

        if (carry > 0) {
            string.insert(0, carry);
        }
        
        return string.toString();
    }
}
