class Solution {
    public int solve(int index, int [] prices, int [][] dp, int buy){
       if(index==prices.length) return 0;
       if(dp[index][buy]!=-1) return dp[index][buy];
       int price=0;
       if(buy==1){
        price=Math.max((-prices[index]+solve(index+1,prices,dp,0)),solve(index+1,prices,dp,1));
        
       }
       else{
        price=Math.max((prices[index]+solve(index+1,prices,dp,1)),solve(index+1,prices,dp,0));
       }
         return dp[index][buy]=price;
    }
    public int maxProfit(int[] prices) {
        int [][] dp = new int[prices.length+1][2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,prices,dp,1);
    }
}