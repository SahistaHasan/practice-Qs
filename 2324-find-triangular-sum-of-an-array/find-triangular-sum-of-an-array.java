class Solution {
    public int triangularSum(int[] nums) {
        for(int i=nums.length-2;i>=0;i--){
            int k=0;
            
            for(int j=0;j<=i;j++){
                nums[k]=(nums[j]+nums[j+1])%10;
                k++;
            }
        }
        return nums[0];
    }
}