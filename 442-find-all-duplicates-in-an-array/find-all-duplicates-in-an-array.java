class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int i=0;
        int j=1;
      while(j<nums.length){
        if(nums[j]==nums[i]){
            list.add(nums[j]);
        }
            j++;
            i++;
        

        

      }
      return list;
    }
}