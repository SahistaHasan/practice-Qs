class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Long> list = new ArrayList<>();
        int mod = 1000000007;
        for(int i=0;i<nums.length;i++){
            long sum=0;
            for(int j=i;j<nums.length;j++){
               sum=sum+nums[j];
               list.add(sum);
            }
        }
        long sum2=0;
        Collections.sort(list);
        for(int i=left-1;i<right;i++){
            sum2=sum2+list.get(i);
        }
        return (int)(sum2%mod);
    }
}