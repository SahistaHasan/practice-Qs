class Solution {
    public int minMoves2(int[] nums) {
        int sum=0;
        Arrays.sort(nums);
       int median=(nums.length)/2;
       for(int i=0;i<nums.length;i++){
        sum=sum+Math.abs(nums[i]-nums[median]);
       }

return sum;
    }
}