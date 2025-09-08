class Solution {
    public boolean nozero(int i){
        while(i!=0){
           int rem=i%10;
           if(rem==0) return false;
           i=i/10;
        }
        return true;
    }
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<n;i++){
            int sub=n-i;
            if(nozero(sub) && nozero(i)){
                return new int[]{i,sub};
            }
        }
        return new int[]{0,0};
    }
}