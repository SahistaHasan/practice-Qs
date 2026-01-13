class Solution {
    
    public int recurse(int n,int[] dp, int index){
       if(index==0) return 1;
       if(index<0) return 0;

       if(dp[index]!=-1) return dp[index];
       int res=recurse(n,dp,index-1)+recurse(n,dp,index-2);
       return dp[index]=res;

    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return recurse(n,dp,n);
    }
}