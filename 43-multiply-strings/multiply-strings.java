class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        int [] arr = new int[num1.length()+num2.length()];
        
        for(int i=num1.length()-1;i>=0;i--){
            int mul=1;
            int mul2=1;
            int carry=0;
            
            for(int j=num2.length()-1;j>=0;j--){
                
               int a = num1.charAt(i) -'0';
               int b = num2.charAt(j)-'0';
                mul=a*b;
                mul2=(mul+carry+arr[i+j+1]);
                 
                arr[i+j+1]=mul2%10;
               arr[i + j] +=  mul2/ 10;
               
            }
           
            
        }
        for (int num : arr) {
             if (!(sb.length() == 0 && num == 0)){
    sb.append(num); 
             }
        }
        return sb.toString();
    }
}