class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        int j=0;
        while(j<nums.length){
            if(nums[j]==0 && nums[j]==nums[i]){
                j++;
            }
            else if(nums[j]!=nums[i] && nums[i]==0){
        int temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
        i++;
        j++;
            }
            else {
                i++;
                j++;
            }
        }
        return;
    }
}