class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        fill(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int orig) {
        int rows = image.length;
        int cols = image[0].length;

        if (Math.min(sr, sc) < 0 || sr > rows - 1 || sc > cols - 1 || image[sr][sc] == color || image[sr][sc] != orig) {
            return;
        }

        int tmp = image[sr][sc];
        image[sr][sc] = color;

        fill(image, sr + 1, sc, color, tmp);
        fill(image, sr - 1, sc, color, tmp);
        fill(image, sr, sc + 1, color, tmp);
        fill(image, sr, sc - 1, color, tmp);

        return;
    }   
}