class Solution {
    
    public int recurse(int n,int[] dp, int index){
        if(index==n) {
            
            return 1 ;
        }
        if(index>n) return 0;
        if(dp[index]!=-1) return dp[index];
        int one = recurse(n,dp,index+1);
        int two=recurse(n,dp,index+2);
        return dp[index]=one+two;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return recurse(n,dp,0);
    }
}