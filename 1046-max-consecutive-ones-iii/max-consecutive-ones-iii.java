class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0;
        int max=-1;
        for(int j=0;j<nums.length;j++){
            if(nums[j]==0) k--;
            while(k<0){
                if(nums[i]==0){
                    i++;
                    k++;
                }
                else i++;
            }
            max=Math.max(max,j-i+1);
        }
        return max;
    }
}