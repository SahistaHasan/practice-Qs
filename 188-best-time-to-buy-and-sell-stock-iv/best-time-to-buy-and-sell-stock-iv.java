class Solution {
     public int solve(int [] prices,int [][][] dp, int n){
          for(int i=prices.length-1;i>=0;i--){
          for(int j=0;j<2;j++){
            for(int k=1;k<=n;k++){
                if(j==1){
                    dp[i][j][k]=Math.max(-prices[i]+dp[i+1][0][k],dp[i+1][1][k]);
                }
                else{
                    dp[i][j][k]=Math.max(prices[i]+dp[i+1][1][k-1],dp[i+1][0][k]);
                }
            }
          }
        }
        return dp[0][1][n];
     }
     
    public int maxProfit(int k, int[] prices) {
         int [][][] dp = new int[prices.length+1][2][k+1];
         return solve(prices,dp,k);
    }
}