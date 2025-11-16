class Solution {
    public int findMin(int[] nums) {
        int high=nums.length-1;
        int ans=-1;
        int low=0;
    
        if (nums[low] <= nums[high]) return nums[0];
        while(high>=low){
            int mid=(high+low)/2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) return nums[mid + 1];

            if(nums[mid]>=nums[low]){
                
                low=mid+1;
            }
            else {
               
                 high=mid-1;
            }

        }
        return -1;
    }
}