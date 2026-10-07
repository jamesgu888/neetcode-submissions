class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> free = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')') {
                if (!open.isEmpty()) {
                    open.pop();
                } else if (!free.isEmpty()) {
                    free.pop();
                } else {
                    return false;
                }
            } else if (c == '(') {
                open.push(i);
            } else if (c == '*') {
                free.push(i);
            }
        }

        while (!open.isEmpty()) {
            if (free.isEmpty() || free.peek() < open.peek()) {
                return false;
            }

            open.pop();
            free.pop();
        }

        return open.isEmpty();
    }
}
