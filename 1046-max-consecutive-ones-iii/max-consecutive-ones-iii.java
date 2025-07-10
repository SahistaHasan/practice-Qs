class Solution {
    public int longestOnes(int[] nums, int k) {
        //
        int i=0;
        int flag=0;
        int count=0;
        int max=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]==0){
                flag++;
            }
               
                    count++;
                if(flag<=k){
                    max=Math.max(max,count);
                }
            
            while(flag>k){
                max=Math.max(max,count-1);
              if(nums[i]==0){
                flag--;
                i++;
                count--;
              }
              else{
                i++;
                count--;
              }
            }
            
        }
        return max;
    }
}