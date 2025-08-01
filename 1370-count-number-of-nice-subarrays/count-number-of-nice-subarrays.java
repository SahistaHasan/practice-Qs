class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int odd = 0;
        int i = 0;
        int prefix = 0;  // counts how many valid start positions we have

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 != 0) {
                odd++;
                prefix = 0;  // reset prefix count whenever a new odd is added
            }

            while (odd == k) {
                if (nums[i] % 2 != 0) {
                    odd--;
                }
                prefix++;
                i++;
            }

            count += prefix; // add all valid subarrays ending at j
        }

        return count;
    }
}
