class Solution {
    public boolean pow(int n){
        if(n==0) return false;
        while(n!=1){
            if(n%3!=0) return false;
            n=n/3;
        }
        return true;
    }
    public boolean isPowerOfThree(int n) {
        return pow(n);
    }
}