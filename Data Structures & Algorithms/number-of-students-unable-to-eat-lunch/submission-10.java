class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        int circle = 0;
        int square = 0;

        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }

        for (int i = 0; i < students.length; i++) {
            if (students[i] == 0) {
                circle++;
            } else {
                square++;
            }

            queue.offer(students[i]);
        }

        while (true) {
            if (queue.isEmpty()) {
                return 0;
            }

            int stackNum = stack.peek();
            int queueNum = queue.peek();

            if (circle == 0 && stackNum == 0 || square == 0 && stackNum == 1) {
                return queue.size();
            } 

            if (stackNum == queueNum) {
                stack.pop();
                queue.poll();
                
                if (queueNum == 0) {
                    circle--;
                } else {
                    square--;
                }
            } else {
                queue.offer(queue.poll());
            }
        }
    }
}