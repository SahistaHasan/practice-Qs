class Solution {
    public int countHomogenous(String s) {
        long count=0;
        long MOD=1000000007;
        int j=0;
        for(int i=0;i<s.length();i++){
            while(j<s.length() && s.charAt(j)==s.charAt(i)){
                j++;
            }
            long n = j-i;
            count=(count+(n)*(n+1)/2)%MOD;
            i=j-1;
        }
        return (int)count;
    }
}