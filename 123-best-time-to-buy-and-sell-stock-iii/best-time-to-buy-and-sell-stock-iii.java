class Solution {
    public int solve(int [] prices, int index, int buy,int no,int [][][]dp){
       if(no==0) return 0;
       if(index==prices.length) return 0;
        if(dp[index][buy][no]!=-1) return dp[index][buy][no];
        int prices1=0;
        int prices2=0;
        if(buy==1){
            prices1=-prices[index]+solve(prices,index+1,0,no,dp);
            prices2=solve(prices,index+1,1,no,dp);
        }
        else{
            prices1 = prices[index]+solve(prices,index+1,1,no-1,dp);
            prices2=solve(prices,index+1,0,no,dp);
        }
        return dp[index][buy][no]=Math.max(prices1,prices2);
    }
    public int maxProfit(int[] prices) {
        int [][][] dp = new int[prices.length+1][2][3];
        for (int i = 0; i < dp.length; i++) {
           for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
    }
}
         return solve(prices,0,1,2,dp);
        
    }
}