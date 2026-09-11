class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix[0].length;
        int colLen = matrix.length;
        int l = 0, r = rowLen * colLen - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            int row = mid / rowLen;
            int col = mid % rowLen;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}
