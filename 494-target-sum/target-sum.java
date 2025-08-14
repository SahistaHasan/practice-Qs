class Solution {
    
    public int recurse(int[]nums, int target, int index){
       if (index < 0) return target == 0 ? 1 : 0;

        int right=recurse(nums,target-nums[index],index-1);
        int left = recurse(nums,target+nums[index],index-1);

       return right+left; 

    }
    public int findTargetSumWays(int[] nums, int target) {
        
        
        return recurse(nums,target,nums.length-1);
    }
}