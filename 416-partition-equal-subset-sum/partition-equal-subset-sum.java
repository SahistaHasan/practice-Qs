class Solution {
    public boolean recurse(int[] nums,int index, int target,int sum, int [][]dp){
        if(sum>target){
            return false;
        }
        if(sum==target){
                return true;
            }
            
        if(index==0){
            if(sum+nums[index]==target){
                return true;
            }
            else{
                return false;
            }
        }
        if(dp[index][sum]!=-1) {
            if(dp[index][sum]==1){
                return true;
            }
            else{
                return false;
            }
        }

        boolean taken=recurse(nums,index-1,target,sum+nums[index],dp);
        boolean nottaken=recurse(nums,index-1,target,sum,dp);
        if(taken||nottaken ){
            dp[index][sum]=1;
        }
        else{
            dp[index][sum]=0;
        }
        return taken||nottaken;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        if(sum%2==0) sum=sum/2;
        else return false;
        int [][] dp = new int[nums.length][sum];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return recurse(nums,nums.length-1,sum,0,dp);
    }
}