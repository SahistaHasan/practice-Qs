class Solution {
    
    public int expand(int i, int j, String s){
        int count=0;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int count=0;
        
        for(int i=0;i<s.length();i++){
           int s1= expand(i,i,s);
           int s2= expand(i,i+1,s);
           count=count+s1+s2;

        }
        return count;
    }
}