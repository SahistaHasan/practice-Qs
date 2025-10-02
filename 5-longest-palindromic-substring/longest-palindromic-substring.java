class Solution {
    public String expand(int i, int j, String s){
        if(i<0 || j>=s.length()) return "";
        while (i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return s.substring((i+1),j);
    }
    public String longestPalindrome(String s) {
       String longest="";
       for(int i=0;i<s.length();i++){
        String s1=expand(i,i,s);
        String s2=expand(i,i+1,s);
        
        String currLongest = s1.length() > s2.length() ? s1 : s2;
            
            if (currLongest.length() > longest.length()) {
                longest = currLongest;
       }
       }
       return longest;
    }
}