class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int i=0;
        int j=0;
        long sum=0;
        while(k!=0){
            if(happiness[happiness.length-1-i]-j>=0){
            sum=sum+happiness[happiness.length-1-i]-j;
            }
            i++;
            j++;
            k--;
        }
        return sum;
    }
}