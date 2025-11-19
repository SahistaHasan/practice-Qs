class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int ans=original;
        while(set.contains(ans)){
          ans=ans*2;
        }
        return ans;
    }
}