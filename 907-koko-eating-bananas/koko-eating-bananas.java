class Solution {
    public long time(int banana_per_hour,int[]piles){
      int unit=banana_per_hour;
      long sum=0;
      for(int i=0;i<piles.length;i++){
      sum=sum+(int)Math.ceil((double)piles[i] / unit);
      }
      return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int ans=-1;
        int high=-1;
        for(int i=0;i<piles.length;i++){
           high=Math.max(high,piles[i]);
        }
        while(high>=low){
            int mid=(high+low)/2;
           
           if(time(mid,piles)>h){
           low=mid+1;
           }
           else{
            ans=mid;
            high=mid-1;
           }
        }
        return ans;
    }
}