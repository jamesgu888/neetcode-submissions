class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;

        // intervals before newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }

        // overlapping with newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);

        // intervals after newInterval
        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }

        int[][] res = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
        }

        return res;
    }
}
