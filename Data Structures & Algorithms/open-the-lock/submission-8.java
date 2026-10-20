class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> dead = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int turns = 0;

        for (String deadend : deadends) {
            dead.add(deadend);
        }

        if (dead.contains(target)) {
            return -1;
        }

        queue.offer("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                if (dead.contains(cur) || visited.contains(cur)) {
                    continue;
                } else if (cur.equals(target)) {
                    return turns;
                }

                add(queue, cur);
                visited.add(cur);
            }

            turns++;
        }

        return -1;
    }

    private void add(Queue<String> queue, String cur) {
        char[] arr = cur.toCharArray();

        for (int i = 0; i < cur.length(); i++) {
            char original = arr[i];

            arr[i] = (char) ('0' + (original - '0' + 1) % 10);
            queue.offer(new String(arr));

            arr[i] = (char) ('0' + (original - '0' + 9) % 10);
            queue.offer(new String(arr));

            arr[i] = original;
        }
    }
}