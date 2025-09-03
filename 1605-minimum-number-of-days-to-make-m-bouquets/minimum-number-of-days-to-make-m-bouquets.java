class Solution {
    public int boq(int day, int m, int k, int[] arr){
             int count=0;
             int sum=0;
             for(int i=0;i<arr.length;i++){
                if(day>=arr[i]){
                    count++;
                }
                else{
                    sum=sum+count/k;
                    count=0;
                }
             }
              sum=sum+count/k;
             return sum;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length) return -1;
        int high=-1;
        for(int i=0;i<bloomDay.length;i++){
            high=Math.max(high,bloomDay[i]);
        }
        int low=Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            low=Math.min(low,bloomDay[i]);
        }
        int ans=-1;
        while(high>=low){
            int mid=(high+low)/2;
            if(boq(mid,m,k,bloomDay)>=m){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}