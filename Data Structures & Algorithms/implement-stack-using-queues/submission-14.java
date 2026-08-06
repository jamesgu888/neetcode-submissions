class MyStack {
    private Queue<Integer> queue;
    private Queue<Integer> tempQueue;

    public MyStack() {
        queue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.offer(x);
    }
    
    public int pop() {
        while (queue.size() != 1) {
            tempQueue.offer(queue.poll());
        }

        int res = queue.poll();

        while (!tempQueue.isEmpty()) {
            queue.offer(tempQueue.poll());
        }

        return res;
    }
    
    public int top() {
        while (!queue.isEmpty()) {
            tempQueue.offer(queue.poll());
        }

        int res = 0;

        while (!tempQueue.isEmpty()) {
            if (tempQueue.size() == 1) {
                res = tempQueue.peek();
            }

            queue.offer(tempQueue.poll());
        }

        return res;
    }
    
    public boolean empty() {
        return queue.isEmpty();
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