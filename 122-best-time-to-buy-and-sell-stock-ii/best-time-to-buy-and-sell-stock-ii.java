class Solution {
    // public int solve(int index, int [] prices, int [][] dp, int buy){
    //    if(index==prices.length) return 0;
    //    if(dp[index][buy]!=-1) return dp[index][buy];
    //    int price=0;
    //    if(buy==1){
    //     price=Math.max((-prices[index]+solve(index+1,prices,dp,0)),solve(index+1,prices,dp,1));
        
    //    }
    //    else{
    //     price=Math.max((prices[index]+solve(index+1,prices,dp,1)),solve(index+1,prices,dp,0));
    //    }
    //      return dp[index][buy]=price;
    // }
    public int solve(int [] prices, int [][] dp){
       dp[prices.length][0]=0;
       dp[prices.length][1]=0;
       for(int i=prices.length-1;i>=0;i--){
         for(int j=0;j<2;j++){
            if(j==1){
                dp[i][j]=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
            }
            else{
                dp[i][j]=Math.max(prices[i]+dp[i+1][1],dp[i+1][0]);
            }
         }

       }
       return dp[0][1];
    }
    
    public int maxProfit(int[] prices) {
        int [][] dp = new int[prices.length+1][2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(prices,dp);
    }
}