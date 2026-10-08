class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int min = Integer.MAX_VALUE;

        while (l <= r) {
            int middle = l + (r - l) / 2;

            if (totalHours(piles, middle) <= h) {
                min = Math.min(min, middle);
                r = middle - 1;
            } else if (totalHours(piles, middle) > h) {
                l = middle + 1;
            }
        }

        return min;
    }

    public int totalHours(int[] piles, int k) {
        int total = 0;

        for (int pile : piles) {
            total += (pile % k == 0) ? (pile / k) : (pile / k + 1);
        }

        return total;
    }
}
