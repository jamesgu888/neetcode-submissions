class Solution {
    public int countPaths(int[][] grid) {
        return countHelper(grid, 0, 0, new HashSet<List<Integer>>());
    }

    private int countHelper(int[][] grid, int r, int c, Set<List<Integer>> visited) {
        int rows = grid.length;
        int cols = grid[0].length;
        List list = new ArrayList<>();
        list.add(r);
        list.add(c);

        if (Math.min(r, c) < 0 || r > rows - 1 || c > cols - 1 || grid[r][c] == 1 || visited.contains(list)) {
            return 0;
        }

        if (r == rows - 1 && c == cols - 1) {
            return 1;
        }

        int count = 0;
        visited.add(list);

        count += countHelper(grid, r + 1, c, visited);
        count += countHelper(grid, r - 1, c, visited);
        count += countHelper(grid, r, c + 1, visited);
        count += countHelper(grid, r, c - 1, visited);

        visited.remove(list);
        return count;
    }
}
