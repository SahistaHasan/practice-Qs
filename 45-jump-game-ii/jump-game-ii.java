class Solution {
    public int recurse(int [] nums, int index,int[] dp){
        if(index>=nums.length) return Integer.MAX_VALUE;
        if(index==nums.length-1) {
            return 1;
        }
        if(dp[index]!=-1) return dp[index];
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=nums[index];i++){
            int next = recurse(nums, index +i, dp);
    if (next != Integer.MAX_VALUE) {
        min = Math.min(min, 1 + next);
    }
        }
        
         dp[index]=min;
        
         return min;
    }
    public int jump(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp,-1);
     return recurse(nums,0,dp)-1;
    }
}