class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // prefix sum 0 occurs once initially

        for (int num : nums) {
            int val = (num % 2 == 0) ? 0 : 1; // convert even → 0, odd → 1
            prefixSum += val;

            // check if there's a prefix with sum (prefixSum - k)
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // record this prefix sum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
