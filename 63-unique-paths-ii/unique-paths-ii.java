class Solution {
    public int dp(int[][]grid,int i,int j,int m,int n,int [][]dp){
        if(i<0 || i>=m || j>=n || j<0){
            return 0;
        }
        if( grid[i][j]==1){
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        
        
        if(dp[i][j]!=-1) return dp[i][j];
        int up = dp(grid,i-1,j,m,n,dp);
        int left = dp(grid,i,j-1,m,n,dp);
        return dp[i][j]=up+left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m =obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][]dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return dp(obstacleGrid,m-1,n-1,m,n,dp);
    }
}