class Solution {
    public int maxArea(int[] heights) {
        int area = Integer.MIN_VALUE;
        int l = 0, r = heights.length - 1;

        while (l < r) {
            int height = Math.min(heights[l], heights[r]);
            area = Math.max(area, height * (r - l));

            if (heights[l] == height) {
                l++;
            } else {
                r--;
            }
        }

        return area;
    }
}
