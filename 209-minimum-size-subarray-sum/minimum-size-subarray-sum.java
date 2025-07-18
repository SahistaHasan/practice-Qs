class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minlen=Integer.MAX_VALUE;
        int length=0;
        int i=0;
        int sum=0;
        for(int j=0;j<nums.length;j++){
            sum=sum+nums[j];
            length++;
            
            while(sum>=target){
                minlen=Math.min(length,minlen);
                sum=sum-nums[i];
                i++;
                length--;
                if(sum>=target){
                    minlen=Math.min(minlen,length);
                }
            }
        }
        if(minlen==Integer.MAX_VALUE) return 0;
        else return minlen;
    }
}