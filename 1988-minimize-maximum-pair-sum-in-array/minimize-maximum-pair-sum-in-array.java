class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        int max=Integer.MIN_VALUE;
        while(j>i){
             max=Math.max(nums[j]+nums[i],max);
            j--;
            i++;
        }
        return max;
    }
}