class Solution {
    int min=Integer.MAX_VALUE;
    public void recurse(int index,int sum,int[] cost,int [] dp){
    if(index>cost.length-1){
        min=Math.min(sum,min);
     return;
    }
    
        if(dp[index]!=-1 && dp[index]<=sum) {
        
           return;
         }
        dp[index]=sum;
        
    
    recurse(index+1,sum+cost[index],cost,dp);
    recurse(index+2,sum+cost[index],cost,dp);
    }
    
    public int minCostClimbingStairs(int[] cost) {
        int [] dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
        recurse(0, 0, cost, dp); 
        recurse(1, 0, cost, dp);
        return min;
    }
}