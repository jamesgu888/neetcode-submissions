class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];

        if (original == color) {
            return image;
        }

        fill(image, sr, sc, original, color);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int original, int color) {
        int rows = image.length;
        int cols = image[0].length;

        if (sr < 0 || sc < 0 ||
            sr >= rows || sc >= cols ||
            image[sr][sc] != original) {
            return;
        }

        image[sr][sc] = color;

        fill(image, sr + 1, sc, original, color);
        fill(image, sr - 1, sc, original, color);
        fill(image, sr, sc + 1, original, color);
        fill(image, sr, sc - 1, original, color);
    }
}