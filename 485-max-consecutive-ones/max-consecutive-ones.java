class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       
        int count=0;
        int max=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            
           while(i<nums.length && nums[i]==1){
                count++;
                max=Math.max(max,count);
                i++;
           }
           count=0;

        }
        return max;
    }
}