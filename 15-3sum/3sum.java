class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set=new HashSet<>();
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length){
            while(i!=0 &&  i<nums.length && nums[i]==nums[i-1] ) i++;
            int j=i+1;
           
            int k=nums.length-1;
           
            while(j<k ){
              if(nums[i]+nums[j]+nums[k]==0){
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]); list.add(nums[j]); list.add(nums[k]);
                set.add(list);
                j++;
                k--;
                while(nums[j]==nums[j-1] && j<k) j++;
                while(nums[k]==nums[k+1] && k>j) k--;
              }
              else if(nums[i]+nums[j]+nums[k]>0) k--;
              else j++;
            }
            i++;
        }
         List<List<Integer>> list = new ArrayList<>();
         for(List<Integer> elem:set){
            list.add(elem);
         }
         return list;
    }
}