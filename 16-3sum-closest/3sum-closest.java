class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;i++){
            int left =i+1;
            int right = nums.length-1;
           
            while(left<right){
                 int currsum=nums[i]+nums[left]+nums[right];
                if(Math.abs(currsum-target)< Math.abs(closest-target)){
                    closest = currsum;
                }
                if(currsum<target){
                    left++;
                }
                else if(currsum>target){
                    right--;
                }
                else return currsum;
            }
        }
        return closest;
    }
}