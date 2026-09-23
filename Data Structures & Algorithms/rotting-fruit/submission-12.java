class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int min = 0;
        while (fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];

                int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                for (int[] dir : directions) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    if (newR < 0 || newC < 0 || newR > rows - 1 || newC > cols - 1 || grid[newR][newC] != 1) {
                        continue;
                    }

                    grid[newR][newC] = 2;
                    fresh--;
                    queue.offer(new int[]{newR, newC});
                }
            }

            min++;
        }

        return (fresh == 0) ? min : -1;
    }
}
