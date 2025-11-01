class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int N = rows * cols;

        long expectedSum = (long) N * (N + 1) / 2L;
        long expectedSquareSum = (long) N * (N + 1) * (2L * N + 1) / 6L;

        long actualSum = 0L;
        long actualSquareSum = 0L;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = grid[i][j];
                actualSum += val;
                actualSquareSum += (long) val * val;
            }
        }

        long diff1 = actualSum - expectedSum;           // x - y
        long diff2 = actualSquareSum - expectedSquareSum; // x^2 - y^2

        long sumXY = diff2 / diff1;                     // x + y
        long repeated = (sumXY + diff1) / 2;            // x
        long missing = repeated - diff1;                // y

        return new int[] { (int) repeated, (int) missing };
    }
}
