class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int r, int c, int i) {
        int rows = board.length;
        int cols = board[0].length;

        if (r < 0 || c < 0 || r > rows - 1 || c > cols - 1 || board[r][c] != word.charAt(i) || board[r][c] == '#') {
            return false;
        }

        if (i == word.length() - 1) {
            return true;
        }

        char tmp = board[r][c];
        board[r][c] = '#';
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            if (dfs(board, word, r + dir[0], c + dir[1], i + 1)) {
                return true;
            }
        }
        board[r][c] = tmp;

        return false;
    }
}
