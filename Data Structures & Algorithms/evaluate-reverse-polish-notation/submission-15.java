class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String cur = tokens[i];
            int res = 0;

            if (cur.equals("+")) {
                res = stack.pop();
                stack.push(stack.pop() + res);
            } else if (cur.equals("-")) {
                res = stack.pop();
                stack.push(stack.pop() - res);
            } else if (cur.equals("*")) {
                res = stack.pop();
                stack.push(stack.pop() * res);
            } else if (cur.equals("/")) {
                res = stack.pop();
                stack.push(stack.pop() / res);
            } else {
                stack.push(Integer.parseInt(cur));
            }
        }

        return stack.pop();
    }
}
