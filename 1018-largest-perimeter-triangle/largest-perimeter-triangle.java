class Solution {
    public int largestPerimeter(int[] nums) {
     Arrays.sort(nums);
     int max=0;
     int i=0;
     while(i<nums.length-2){
        if(nums[i]+nums[i+1]>nums[i+2]){
            max=Math.max(nums[i]+nums[i+1]+nums[i+2],max);
        }
        i++;
     }
     return max;
    }
}