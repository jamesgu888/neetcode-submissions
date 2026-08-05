class BrowserHistory {
    private Stack<String> history;
    private Stack<String> temp;

    public BrowserHistory(String homepage) {
        history = new Stack<>();
        history.push(homepage);
        temp = new Stack<>();
    }
    
    public void visit(String url) {
        history.push(url);
        temp.clear();
    }
    
    public String back(int steps) {
        for (int i = 0; i < steps; i++) {
            temp.push(history.pop());

            if (history.isEmpty()) {
                history.push(temp.pop());
                break;
            }
        }

        return history.peek();
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps; i++) {
            if (temp.isEmpty()) {
                break;
            }
            history.push(temp.pop());
        }

        return history.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */