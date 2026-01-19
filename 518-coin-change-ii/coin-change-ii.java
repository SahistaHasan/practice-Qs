class Solution {
    
    public int recurse(int amount,int[]coins,int[][]dp,int index){
       if(index==0){
        if( amount%coins[index]==0) return 1 ;
        else return 0;
       }
      
       if(dp[index][amount]!=-1)return dp[index][amount];
      
       int nottake = recurse(amount,coins,dp,index-1);
       int take=0;
       if(amount>=coins[index]){
        take=recurse(amount-coins[index],coins,dp,index);
       }
       return dp[index][amount]=nottake+take;
    }
    public int change(int amount, int[] coins) {
        int [][]dp=new int[coins.length][amount+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
       return  recurse(amount,coins,dp,coins.length-1);
       
    }
    
}