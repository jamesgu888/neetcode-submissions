class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        Stack<Integer> tmp = new Stack<>();
        
        while (!minStack.isEmpty() && val > minStack.peek()) {
            tmp.push(minStack.pop());
        }

        minStack.push(val);

        while (!tmp.isEmpty()) {
            minStack.push(tmp.pop());
        }
    }
    
    public void pop() {
        int val = stack.pop();

        Stack<Integer> tmp = new Stack<>();

        while (minStack.peek() != val) {
            tmp.push(minStack.pop());
        }

        minStack.pop();

        while (!tmp.isEmpty()) {
            minStack.push(tmp.pop());
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
