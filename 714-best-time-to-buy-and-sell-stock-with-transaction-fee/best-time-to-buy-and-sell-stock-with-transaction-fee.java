class Solution {
    public int solve(int [] prices, int [][] dp,int index, int buy,int fee){
        if(index==prices.length) return 0;
        if(dp[index][buy]!=-1) return dp[index][buy];
        int prices1=0;
        int prices2=0;
        if(buy==1){
            prices1=-prices[index] +solve(prices,dp,index+1,0,fee);
            prices2=solve(prices,dp,index+1,1,fee);
        }
        else{
            prices1=-fee+prices[index]+solve(prices,dp,index+1,1,fee);
            prices2=solve(prices,dp,index+1,0,fee);
        }
         return dp[index][buy]=Math.max(prices1,prices2);
    }
    public int maxProfit(int[] prices, int fee) {
        int [][] dp = new int[prices.length+1][2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
    }
    return solve(prices,dp,0,1,fee);
    }
}