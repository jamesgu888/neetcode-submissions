class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    exploreIsland(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private void exploreIsland(char[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> dirs = new ArrayList<>();
        dirs.add(new int[]{0, -1});
        dirs.add(new int[]{1, 0});
        dirs.add(new int[]{0, 1});
        dirs.add(new int[]{-1, 0});

        queue.offer(new int[]{r, c});
        grid[r][c] = '0';

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int[] dir : dirs) {
                    int[] tmp = new int[]{cur[0] + dir[0], cur[1] + dir[1]};

                    if (tmp[0] >= 0 && tmp[0] < grid.length &&
                        tmp[1] >= 0 && tmp[1] < grid[0].length && grid[tmp[0]][tmp[1]] == '1') {
                        queue.offer(tmp);
                        grid[tmp[0]][tmp[1]] = '0';
                    }
                }
            }
        }
    }
}
