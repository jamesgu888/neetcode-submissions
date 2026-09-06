class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int student : students) {
            queue.offer(student);
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            if (sandwiches[idx] == queue.peek()) {
                queue.poll();
                idx++;
            } else {
                int counter = 0;
                while (!queue.isEmpty()) {
                    if (counter == queue.size()) {
                        return queue.size();
                    } else if (sandwiches[idx] == queue.peek()) {
                        queue.poll();
                        idx++;
                        break;
                    }

                    queue.offer(queue.poll());
                    counter++;
                }
            }
        }

        return queue.size();
    }
}