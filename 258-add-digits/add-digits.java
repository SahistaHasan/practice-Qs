class Solution {
    public int addDigits(int num) {
        
        while(num/10!=0){
          int n=num;
          num=0;
          while(n!=0){
            num=num+n%10;
            n=n/10;
          }
        }
        return num;
    }
}