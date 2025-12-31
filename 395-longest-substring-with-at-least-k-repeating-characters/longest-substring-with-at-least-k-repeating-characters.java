class Solution {
    public int longestSubstring(String s, int k) {
        int [] freq = new int[26];
        if(s.length()==1){
            if(k==1) return 1;
            else return 0;
        }
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']<k){
                int left=longestSubstring(s.substring(0,i),k);
                int right = longestSubstring(s.substring(i+1,s.length()),k);
                return Math.max(left,right);
            }
        }
        return s.length();
        
    }
}