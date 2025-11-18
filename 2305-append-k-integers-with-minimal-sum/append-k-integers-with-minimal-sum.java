class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);

        // Remove duplicates (critical fix)
        int m = 1;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r] != nums[r - 1]) {
                nums[m++] = nums[r];
            }
        }

        long sum = 0;
        int i = 1;
        int j = 0;
        int count = 0;

        while (count < k) {
            if (j < m && nums[j] == i) {
                j++;
                i++;
            } else {
                sum += i;
                i++;
                count++;
            }
        }

        return sum;
    }
}
