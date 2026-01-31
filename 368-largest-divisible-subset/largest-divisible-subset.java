class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int [] hash = new int[nums.length];
        int [] dp = new int[nums.length+1];
        for(int i=0;i<hash.length;i++){
            hash[i]=i;
        }
        int max=-1;
        int lastindex=-1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }
            }
            if(dp[i]>max){
                max=dp[i];
                lastindex=i;
            }
        }
        while(hash[lastindex]!=lastindex){
            list.add(nums[lastindex]);
            lastindex=hash[lastindex];

        }
        list.add(nums[lastindex]);
        return list;
    }
}