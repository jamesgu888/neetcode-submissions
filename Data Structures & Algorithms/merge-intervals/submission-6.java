class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[1], b[1]);
        });

        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval1 = res.get(res.size() - 1);
            int[] interval2 = intervals[i];

            if (interval2[0] <= interval1[1]) {
                interval1[1] = Math.max(interval1[1], interval2[1]);
            } else {
                res.add(interval2);
            }
        }

        int[][] res2 = new int[res.size()][2];

        for (int i = 0; i < res.size(); i++) {
            res2[i][0] = res.get(i)[0];
            res2[i][1] = res.get(i)[1];
        }

        return res2;
    }
}
