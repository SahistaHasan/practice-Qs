class Solution {
    public long zeroFilledSubarray(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        long count=0;
        long sum=0;
        int i=0;
        while(i<nums.length){
           while(i<nums.length && nums[i]==0){
            count++;
            i++;
           }
           i++;
           sum=sum+(count*(count+1))/2;
           count=0;
        }
        return sum;
    }
}