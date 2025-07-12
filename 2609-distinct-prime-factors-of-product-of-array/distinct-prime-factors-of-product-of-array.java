class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public void primefactors(int elem){
           for(int i=2;i<=elem;i++){
                if(elem%i ==0){
                    map.put(i,map.getOrDefault(i,0)+1);
                    while(elem%i ==0){
                        elem=elem/i;
                    }
                }
            }
    }
    public int distinctPrimeFactors(int[] nums) {
   
        for(int i=0;i<nums.length;i++){
           primefactors(nums[i]);
        }
        return map.size();
    }
}