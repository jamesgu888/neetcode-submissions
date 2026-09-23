class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1) {
            return -1;
        }

        int[][] visited = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        visited[0][0] = 1;
        queue.offer(new int[]{0, 0});

        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = queue.poll();
                int r = tmp[0];
                int c = tmp[1];

                if (r == rows - 1 && c == cols - 1) {
                    length++;
                    return length;
                }

                int[][] directions = {{1, 1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, -1}, {1, 0}};

                for (int[] dir : directions) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    if (newR < 0 || newC < 0 || newR > rows - 1 || newC > cols - 1 || visited[newR][newC] == 1 || grid[newR][newC] == 1) {
                        continue;
                    }

                    visited[newR][newC] = 1;
                    queue.offer(new int[]{newR, newC});
                }
            }

            length++;
        }

        return -1;
    }
}