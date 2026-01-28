class Solution {
    public int solve(int [] prices, int [][][]dp){
         for(int i=prices.length-1;i>=0;i--){
          for(int j=0;j<2;j++){
            for(int k=0;k<=1;k++){
                if(j==1) {
                    if(k==1){
                    dp[i][j][k]=Math.max(-prices[i]+dp[i+1][0][1],dp[i+1][1][1]);
                    }
                    else{
                        dp[i][j][k]=dp[i+1][1][1];
                    }
                }
                else{
                  
                    dp[i][j][k]=Math.max(prices[i]+dp[i+1][1][0],dp[i+1][0][k]);
                    
                   
                }
            }
          }
        }
        return dp[0][1][1];
     
    }
    public int maxProfit(int[] prices) {
        int [][][] dp = new int[prices.length+1][2][2];
         return solve(prices,dp);
    }
}