class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i=0;
        int res=1;
        int count=0;
        int j=0;
        if(k==1) return 0;
        for( j=0;j<nums.length;j++){
            res=res*nums[j];
            while(i<nums.length && res>=k){
                res=res/nums[i];
                i++;
            }
            count=count+(j-i+1);
        }
        
       if(count>0) return count;
       else return 0;
    }
}