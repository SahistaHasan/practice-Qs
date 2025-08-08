class Solution {
    
    public int recurse(int[][]matrix,int i, int j,int [][]dp){
        if( j<0 || j>matrix[0].length-1 ){
            return Integer.MAX_VALUE;
        }
        
       if(i==0){
        
        return matrix[0][j];
       }
       if(dp[i][j]!=-2){
        return dp[i][j];
       }
      int below= recurse(matrix,i-1,j,dp);
      int dialeft= recurse(matrix,i-1,j-1,dp);
     int diaright=  recurse(matrix,i-1,j+1,dp);
     dp[i][j] =matrix[i][j]+ Math.min(below, Math.min(dialeft, diaright));
       return dp[i][j];
    }
    public int minFallingPathSum(int[][] matrix) {
        int [][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
    Arrays.fill(dp[i], -2);
}
       
        int minSum = Integer.MAX_VALUE;
        int n = matrix[0].length;
        // Try every column in the last row as the end point
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, recurse(matrix, matrix.length - 1, j, dp));
        }
        return minSum;
    }
}