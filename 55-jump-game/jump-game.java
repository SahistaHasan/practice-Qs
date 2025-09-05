class Solution {
    public int recurse(int [] dp, int index, int[]nums){
        if(index==nums.length-1) return 0;
        if(index>=nums.length) return 1;
        if(dp[index]!=-1) return dp[index];
        for(int i=1;i<=nums[index];i++){
           if( recurse(dp,index+i,nums)==0){
            return dp[index+i] = 0;
           }
        }
        return dp[index]=1;
    }
    public boolean canJump(int[] nums) {
        int max=-1;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int [] dp=new int[nums.length];
        
            Arrays.fill(dp,-1);
        
        if(recurse(dp,0,nums)==0) return true;
        else return false;
    
    }
}