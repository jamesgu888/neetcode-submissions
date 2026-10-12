class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
        int remove = 0;

        for (int i = 0; i < intervals.length - 1; i++) {
            int[] interval1 = intervals[i];
            int[] interval2 = intervals[i + 1];

            if (interval1[1] > interval2[0]) {
                interval2[1] = Math.min(interval1[1], interval2[1]);
                remove++;
            }
        }

        return remove;
    }
}
