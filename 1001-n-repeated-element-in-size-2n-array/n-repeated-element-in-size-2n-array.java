class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int n = nums.length/2;
        for(Map.Entry<Integer,Integer> e: map.entrySet() ){
            if(e.getValue()==n){
                return e.getKey();
            }
        }
        return -1;
    }
}