class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = Integer.MIN_VALUE;
        int r = 0;
        for (int weight : weights) {
            l = Math.max(l, weight);
            r += weight;
        }

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (getDays(weights, mid) <= days) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private int getDays(int[] weights, int cap) {
        int days = 1;
        int remaining = cap;

        for (int weight : weights) {
            if (remaining - weight < 0) {
                days++;
                remaining = cap;
            }

            remaining -= weight;
        }

        return days;
    }
}