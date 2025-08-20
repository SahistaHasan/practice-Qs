class Solution {
    public int maxProduct(int[] nums) {
        int [] prefix = new int [nums.length];
        int [] suffix = new int [nums.length];
        int mul=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                prefix[i]=0;
                mul=1;
            }
            else{
            mul=mul*nums[i];
            prefix[i]=mul;
        }
        }
        mul=1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]==0){
                mul=1;
                suffix[i]=0;
            }
            else{
            mul=mul*nums[i];
            
            suffix[i]=mul;
        }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<prefix.length;i++){
            max=Math.max(prefix[i],max);
        }
        for(int i=0;i<suffix.length;i++){
            max=Math.max(suffix[i],max);
        }
        return max;
    }
}