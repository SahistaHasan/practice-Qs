class Solution {
    public int longestSubarray(int[] nums) {
        int zero=0;
        int count=0;
        int max=0;
        int j=0;
        int no=0;
        for(int i=0;i<nums.length;i++ ){
          if(nums[i]==0) {
            zero++;
            no++;
          }
          else{
            count++;
          }
          while(zero>1){
            if(nums[j]==0) zero--;
            else count--;
            j++;
          }
          max=Math.max(max,count);
        }
        if(no==0) return nums.length-1;
        return max;  
         }
}