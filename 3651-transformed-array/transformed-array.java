class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int [] result = new int[nums.length];
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                if(nums[i]+i>nums.length-1) result[i]=(nums[(nums[i]+i)%nums.length]);
                else result[i]=nums[nums[i]+i];
            }
            else if(nums[i]<0){
              int  newIndex = ((i + nums[i]) % n + n) % n;
              result[i]=nums[newIndex];
            }
            else{
                result[i]=nums[i];
            }
        }
        return result;
    }
}