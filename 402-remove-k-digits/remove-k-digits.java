class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length()) return "0";
        Stack<Integer> stack=new Stack<>();
        int i=0;
        while(i<num.length()){
            if(k>0){
               
               while(!stack.isEmpty() && stack.peek()>(num.charAt(i)-'0') && k>0 ){
                  stack.pop();
                  k--;
               }
               stack.push(num.charAt(i)-'0');
               
            }
            else{
                stack.push(num.charAt(i)-'0');
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        
            while(k!=0){
          stack.pop();
          k--;
            }
      
        while(!stack.isEmpty()){
          sb.append(stack.pop());

        }
    
         sb.reverse();
            
       while (sb.length() > 1 && sb.charAt(0) == '0') {
        if(sb.charAt(0)!='0') break;
    sb.deleteCharAt(0);
}
return sb.toString();
    }
}