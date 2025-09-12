class Solution {
    public boolean doesAliceWin(String s) {
        int vowels=0;
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='o' || s.charAt(i)=='i' || s.charAt(i)=='u'){
          vowels++;
            }
            i++;
        } 
        if(vowels==0) return false; 
        if(vowels%2==1){
            return true;
        }    
        else return true;
          
    }
}