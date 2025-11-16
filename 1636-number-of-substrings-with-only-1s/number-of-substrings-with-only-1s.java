class Solution {
    public int numSub(String s) {
        int j=0;
        long MOD=1000000007;
        long count =0;
        for(int i=0;i<s.length();i++){
            while(j<s.length() && s.charAt(j)=='1'){
              j++;
            
            }
            long n =j-i;
            count=(count+(n*(n+1)/2))%MOD;
            j++;
            i=j-1;
            
        }
        return (int)count;
    }
}