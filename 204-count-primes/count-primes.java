class Solution {
   
    public int countPrimes(int n) {
        int count=0;
        int[] primeno=new int[n+1];
   for(int i=2;i<=n;i++){
    primeno[i]=1;
   }
   for(int i=2;i<=Math.sqrt(n);i++){
    if(primeno[i]==1){
    for(int j=i*i;j<=n;j+=i){
       primeno[j]=0;
    }
   }
   }
   for(int i=2;i<n;i++){
    if(primeno[i]==1) count++;
   }
   return count;
    }
}