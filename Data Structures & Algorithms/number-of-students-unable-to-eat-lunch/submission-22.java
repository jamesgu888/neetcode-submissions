class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int student : students) {
            queue.offer(student);
        }

        for (int sandwich : sandwiches) {
            if (sandwich == queue.peek()) {
                queue.poll();
            } else {
                int counter = 0;
                
                while (!queue.isEmpty()) {
                    if (counter == queue.size()) {
                        return queue.size();
                    } else if (sandwich == queue.peek()) {
                        queue.poll();
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