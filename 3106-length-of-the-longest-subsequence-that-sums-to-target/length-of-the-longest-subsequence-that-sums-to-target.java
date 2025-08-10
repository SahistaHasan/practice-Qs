class Solution {
    public int recurse(List<Integer>nums, int target, int index,int [][]dp){
        if(target==0){
           
           return 0;
        }
        if(index==0){
           if(target==nums.get(index)){
            return 1;
           }
           else{
            return Integer.MIN_VALUE;
           }
        }
         if(dp[target][index]!=-1) return dp[target][index];
         int nottaken=recurse(nums,target,index-1,dp);
         int taken=Integer.MIN_VALUE;
         if(target>=nums.get(index)){
             taken=recurse(nums,target-nums.get(index),index-1,dp);
             if(taken!=Integer.MIN_VALUE) taken=taken+1;
         }
         return dp[target][index]=Math.max(taken,nottaken);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int [][]dp = new int[target+1][nums.size()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return recurse(nums,target,nums.size()-1,dp)< 0 ? -1 :recurse(nums,target,nums.size()-1,dp);
    }
}