class BrowserHistory {
    private Stack<String> stack1;
    private Stack<String> stack2;

    public BrowserHistory(String homepage) {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

        stack1.push(homepage);
    }
    
    public void visit(String url) {
        stack1.push(url);
        stack2.clear();
    }
    
    public String back(int steps) {
        for (int i = 0; i < steps && stack1.size() > 1; i++) {
            stack2.push(stack1.pop());
        }
        
        return stack1.peek();
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps && !stack2.isEmpty(); i++) {
            stack1.push(stack2.pop());
        }
        
        return stack1.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */