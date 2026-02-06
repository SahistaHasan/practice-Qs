class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int maxlen=Integer.MIN_VALUE;
        for(int j=0;j<nums.length;j++){
           while((long)k*nums[i]<(long)nums[j]){
              i++;
           }
           maxlen=Math.max(maxlen,j-i+1);
        }
        return nums.length - maxlen;
    }
}