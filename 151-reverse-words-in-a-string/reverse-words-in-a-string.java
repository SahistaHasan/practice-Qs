class Solution {
    public String reverseWords(String s) {
        StringBuilder main = new StringBuilder();
        int i=s.length()-1;
        while(i>=0){
            StringBuilder sb = new StringBuilder();
            while(i>=0 && ((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='A' && s.charAt(i)<='Z') || (s.charAt(i)>='0' && s.charAt(i)<='9'))){
                
                    sb.append(s.charAt(i));
                  
                  i--;
            }
            if(sb.length()>0){
                String str = sb.reverse().append(" ").toString();
                main.append(str);
            }
            i--;
        }
        main.setLength(main.length()-1);
        return main.toString();
    }
}