class Solution {
    public int recurse(int [] nums, int index,int previndex , int [][] dp){
       if(index>=nums.length) return 0;
       
       
       if(dp[index][previndex+1]!=-1) return dp[index][previndex+1];
       int pick=0;
      if(previndex==-1 || nums[previndex]<nums[index]){
        pick=1+recurse(nums,index+1,index,dp);
      }
      
       int notpick=recurse(nums,index+1,previndex,dp);
       return dp[index][previndex+1]=Math.max(pick,notpick);
    }
    public int lengthOfLIS(int[] nums) {
     int [][] dp = new int[nums.length][nums.length+1];
    for(int[] row : dp) Arrays.fill(row,-1);
     return recurse(nums,0,-1,dp);  
    }
}