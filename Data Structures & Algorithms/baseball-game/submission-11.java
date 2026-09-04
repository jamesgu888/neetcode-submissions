class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<Integer>();

        for (String operation : operations) {
            if (operation.equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2);
                stack.push(num1);
                stack.push(num1 + num2);
            } else if (operation.equals("D")) {
                int num1 = stack.pop();
                stack.push(num1);
                stack.push(num1 * 2);
            } else if (operation.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(operation));
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}