class Solution {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return bfs(grid, i, j);
                }
            }
        }

        return 0;
    }

    private int bfs(int[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int perimeter = 0;

        queue.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int tmp = 4;

                for (int[] dir : dirs) {
                    int newR = cur[0] + dir[0];
                    int newC = cur[1] + dir[1];

                    if (newR >= 0 && newR < grid.length && 
                        newC >= 0 && newC < grid[0].length && 
                        grid[newR][newC] == 1) {
                        tmp--;
                        if (visited[newR][newC] == false) {
                            queue.offer(new int[]{newR, newC});
                            visited[newR][newC] = true;
                        }
                    }
                }

                perimeter += tmp;
            }
        }

        return perimeter;
    }
}