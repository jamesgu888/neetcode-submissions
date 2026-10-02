class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] cur = {0, 0, 0};

        for (int[] triplet : triplets) {
            if ((triplet[0] <= target[0]) && (triplet[1] <= target[1]) && (triplet[2] <= target[2])) {
                cur[0] = Math.max(cur[0], triplet[0]);
                cur[1] = Math.max(cur[1], triplet[1]);
                cur[2] = Math.max(cur[2], triplet[2]);
            }
        }

        return Arrays.equals(cur, target);
    }
}
