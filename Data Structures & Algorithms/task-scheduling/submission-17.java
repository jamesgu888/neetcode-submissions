class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>(); // character -> frequency

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> heap = new PriorityQueue((a, b) -> { // min heap sorted by 
            return Integer.compare(map.get(b), map.get(a));
        });

        heap.addAll(map.keySet());

        Queue<int[]> cooldown = new LinkedList<>();

        int res = 0;

        while (!heap.isEmpty() || !cooldown.isEmpty()) {
            while (!cooldown.isEmpty() && cooldown.peek()[1] <= res) {
                heap.offer((char) cooldown.poll()[0]);
            }

            if (!heap.isEmpty()) {
                char c = heap.poll();
                map.put(c, map.get(c) - 1);
                if (map.get(c) > 0) {
                    cooldown.offer(new int[]{c, res + n + 1});
                }

                res++;
            } else {
                res = cooldown.peek()[1];
            }
        }

        return res;
    }
}
