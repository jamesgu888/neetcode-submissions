class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            heap.offer(stone);
        }

        while (heap.size() >= 2) {
            int stone1 = heap.poll();
            int stone2 = heap.poll();

            if (stone2 - stone1 != 0) {
                heap.offer(Math.abs(stone2 - stone1));
            }
        }

        if (heap.size() == 0) {
            return 0;
        }

        return heap.poll();
    }
}
