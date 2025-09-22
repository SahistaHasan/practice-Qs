class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();   // frequency
        Map<Integer,Integer> first = new HashMap<>();  // first occurrence
        Map<Integer,Integer> last = new HashMap<>();   // last occurrence
        int max = 0;

        // First pass: build frequency, first index, and last index
        for(int i=0;i<nums.length;i++){
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
            max = Math.max(max, freq.get(nums[i]));

            if(!first.containsKey(nums[i])){
                first.put(nums[i], i);
            }
            last.put(nums[i], i);
        }

        int len = Integer.MAX_VALUE;

        // Second pass: check all numbers with frequency == max
        for(int num : freq.keySet()){
            if(freq.get(num) == max){
                len = Math.min(len, last.get(num) - first.get(num) + 1);
            }
        }

        return len;
    }
}
