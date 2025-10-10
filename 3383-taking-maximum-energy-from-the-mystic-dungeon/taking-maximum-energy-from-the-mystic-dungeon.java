class Solution {
    public int recurse(int []energy, int index, int k, int []dp){
        if(index>energy.length-1) return 0;
        if(dp[index]!=-1) return dp[index];
        int sum=energy[index]+recurse(energy,index+k,k,dp);
        return dp[index]=sum;
    }
    public int maximumEnergy(int[] energy, int k) {
       int[]dp = new int[energy.length];
       Arrays.fill(dp,-1);
       int max=Integer.MIN_VALUE;
       for(int i=energy.length-1;i>=0;i--){
           dp[i]=recurse(energy,i,k,dp);
           max=Math.max(max,dp[i]);
       }
       
       return max;
    }
}