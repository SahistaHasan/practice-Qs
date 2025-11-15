class Solution {
    public boolean isSubsequence(String new_w, String sorted){
        if(new_w.length()>sorted.length()) return false;
         int p=0;
         int q=0;
         while(p<new_w.length() && q<sorted.length()){
            if(new_w.charAt(p) ==sorted.charAt(q)){
                p++;
                q++;
            }
            else q++;
         }
         if(p!=new_w.length()) return false;
         return true;
    }
    public String findLongestWord(String s, List<String> dictionary) {
      
       String ans="";
       

       Collections.sort(dictionary,(a,b)->{
        if(a.length()!=b.length()) return b.length()-a.length();
        return a.compareTo(b);
       });
       for(int i=0;i<dictionary.size();i++){
        if(isSubsequence(dictionary.get(i),s)){
            ans=dictionary.get(i);
            return ans;
        }
        
       }
       return ans;
    }
}