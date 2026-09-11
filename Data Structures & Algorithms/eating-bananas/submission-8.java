class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int p : piles) {
            max = Math.max(max, p);
        }

        int l = 1, r = max;

        int res = max;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canFinish(piles, mid, h)) {
                res = Math.min(res, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }

    private boolean canFinish(int[] piles, int k, int h) {
        int res = 0;
        for (int p : piles) {
            res += (p + k - 1) / k;
        }

        return res <= h;
    }
}
