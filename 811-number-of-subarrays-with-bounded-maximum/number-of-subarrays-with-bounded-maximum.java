class Solution {
    public int solve(int [] nums, int max){
       int left=0;
       int right =0;
       int count=0;
       for( right=0;right<nums.length;right++){
       if(nums[right]>max){
        left=right+1;
        
        continue;
       }
       count=count +(right-left+1);
        
       }
       return count;
    }
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
       return solve(nums,right)-solve(nums,left-1);
    }
}