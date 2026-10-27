class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        if (board[row][col] != '.') {
                            if (set.contains(board[row][col])) {
                                System.out.println("set already contains: " + board[row][col]);
                                return false;
                            } else {
                                set.add(board[row][col]);
                            }
                        }
                    }
                }
                
                set.clear();
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        System.out.println("2");
                        return false;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }
            set.clear();
        }

        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        System.out.println("3");
                        return false;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }
            set.clear();
        }

        return true;
    }
}
