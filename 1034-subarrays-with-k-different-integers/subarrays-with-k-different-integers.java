class Solution {
    public int helper(int[]nums, int k){
     int i=0; int count=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int j=0;j<nums.length;j++){
          map.put(nums[j],map.getOrDefault(nums[j],0)+1);
          
          while( map.size()>k){
            if(map.get(nums[i])>1){
                map.put(nums[i],map.get(nums[i])-1);
            }
            else{
                map.remove(nums[i]);
            }
            i++;
          }
           count += (j - i + 1);
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
       return helper(nums,k)-helper(nums,k-1);
    }
}