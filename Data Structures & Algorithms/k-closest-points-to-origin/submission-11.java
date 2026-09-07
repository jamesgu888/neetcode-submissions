class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int l = 0, r = points.length - 1;
        int pivot = points.length;

        while (pivot != k) {
            pivot = quickSelect(points, l, r);

            if (pivot < k) {
                l = pivot + 1;
            } else if (pivot > k) {
                r = pivot - 1;
            }
        }

        int[][] res = new int[k][2];
        System.arraycopy(points, 0, res, 0, k);
        return res;
    }

    private int quickSelect(int[][] points, int l, int r) {
        int[] pivot = points[r];
        int pivotDst = findDistance(pivot);
        int idx = l;

        for (int i = l; i <= r; i++) {
            if (findDistance(points[i]) < pivotDst) {
                int[] tmp = points[idx];
                points[idx] = points[i];
                points[i] = tmp;

                idx++;
            }
        }

        points[r] = points[idx];
        points[idx] = pivot;

        return idx;
    }

    public int findDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
