class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int min=Integer.MAX_VALUE;
        for(int j=k-1;j<nums.length;j++){
          min=Math.min(nums[j]-nums[i],min);
          i++;
        }
        if(min==Integer.MAX_VALUE) return 0;
        else return min;
    }
}