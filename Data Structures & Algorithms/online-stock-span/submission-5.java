class StockSpanner {
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int[] cur = new int[] {price, 1};

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            int[] prev = stack.pop();
            cur[1] += prev[1];
        }

        stack.push(cur);
        return cur[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */