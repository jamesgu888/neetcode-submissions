class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });
        
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval1 = list.get(list.size() - 1);
            int[] interval2 = intervals[i];

            if (interval2[0] <= interval1[1]) {
                list.set(list.size() - 1, new int[]{Math.min(interval1[0], interval2[0]), Math.max(interval1[1], interval2[1])});
            } else {
                list.add(interval2);
            }
        }

        int[][] res = new int[list.size()][intervals[0].length];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
