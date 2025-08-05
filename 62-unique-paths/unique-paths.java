class Solution {
    public int dp(int i, int j,int m,int n,int[][]dp){
        if(i==0 && j==0){
            return 1;
        }
        if(i>m-1 || j>n-1 || i<0 || j<0){
            return 0;
        }  
        if(dp[i][j]!=-1) return dp[i][j];
       int up= dp(i-1,j,m,n,dp);
       int down=dp(i,j-1,m,n,dp);
       return dp[i][j]=up+down;
        
    }
    public int uniquePaths(int m, int n) {
        int[][]dp= new int[m][n];
         for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dp(m-1,n-1,m,n,dp);
    }
}