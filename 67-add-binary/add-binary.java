class Solution {
    public String addBinary(String a, String b) {
        int sum=0;
        int carry=0;
        int i=a.length()-1;
        int j=b.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0 || carry!=0){
            sum=sum+carry;
         if(i>=0){
            sum=sum+a.charAt(i)-'0';
            i--;
         }
         if(j>=0){
            sum=sum+b.charAt(j)-'0';
            j--;
         }
         carry=sum/2;
         sum=sum%2;
         sb.append(sum);
         sum=0;
        }
        return sb.reverse().toString();
    }
}