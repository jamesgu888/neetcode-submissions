class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int []> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int[] point : points) {
            int distance = findDistance(point);
            heap.offer(new int[]{distance, point[0], point[1]});
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] tmp = heap.poll();
            res[i][0] = tmp[1];
            res[i][1] = tmp[2];
        }

        return res;
    }

    private int findDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
