class Solution {
    public int findPeakElement(int[] nums) {
        int high=nums.length-2;
        int low=1;
        if(nums.length==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
        while(high>=low){
            int mid = (high+low)/2;
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]) return mid;
            if(nums[mid]>nums[mid+1]){
                high=mid;
            }
            else {
                low=mid+1;
            }
        }
        return -1;
    }
}