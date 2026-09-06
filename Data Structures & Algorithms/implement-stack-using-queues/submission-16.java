class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.offer(x);
    }
    
    public int pop() {
        int res = 0;

        while (!queue1.isEmpty()) {
            if (queue1.size() == 1) {
                res = queue1.poll();
            } else {
                queue2.offer(queue1.poll());
            }
        }

        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }

        return res;
    }
    
    public int top() {
        int res = 0;

        while (!queue1.isEmpty()) {
            if (queue1.size() == 1) {
                res = queue1.peek();
            }

            queue2.offer(queue1.poll());
        }

        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }

        return res;
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */