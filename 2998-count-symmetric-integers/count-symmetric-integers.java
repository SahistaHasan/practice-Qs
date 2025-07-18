class Solution {
    public boolean isSymmetric(int num){
        int sum1=0;
        int sum2=0;
        String str = Integer.toString(num);
        if(str.length()%2!=0) return false;
        for(int i=0;i<str.length();i++){
            if(i<str.length()/2){
                 sum1 += str.charAt(i) - '0';
            }
            else{
                sum2 += str.charAt(i) -'0';
            }
        }
        if(sum1==sum2) return true;
        else return false;
    }
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int i=low;i<=high;i++){
            if(isSymmetric(i)){
                count++;
            }
        }
        return count;
    }
}