class Solution {
   
    public int recurse(int[]coins,int amount,int[]dp){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        if(dp[amount]!=-1) return dp[amount];
         int min=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
           int val= recurse(coins,amount-coins[i],dp);
            if(val!=Integer.MAX_VALUE){
                min=Math.min(min,val+1);
            }
        }
        return dp[amount]=min;

    }
    public int coinChange(int[] coins, int amount) {
        int[]dp=new int[amount+1];
        Arrays.fill(dp,-1);
       if (recurse(coins,amount,dp)==Integer.MAX_VALUE){
        return -1;
       }
       else{
        return recurse(coins,amount,dp);
       }
    }
}