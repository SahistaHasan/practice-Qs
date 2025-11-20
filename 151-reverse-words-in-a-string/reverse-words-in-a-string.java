class Solution {
    public String reverseWords(String s) {
       int i=s.length()-1;
       StringBuilder ans = new StringBuilder();
       while(i>=0){
        StringBuilder sb = new StringBuilder();
        while(i>=0 && s.charAt(i)!=' '){
            sb.append(s.charAt(i));
            i--;
        }
        if(sb.length()>0){
            sb.append(" ");
            ans.append(sb.reverse());
            
        }
        i--;
       }
      ans.deleteCharAt(0);
      String p = ans.toString();
      return p;
    }
}