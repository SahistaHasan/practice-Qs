class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i=0;
        int maxfreq=0;int maxlen=0;
        for(int j=0;j<s.length();j++){
             map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
             maxfreq=Math.max(maxfreq,map.get(s.charAt(j)));
             int valid=(j-i+1)-maxfreq;
             while(i<s.length() && valid>k){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
                valid=(j-i+1)-maxfreq;
             }
             maxlen=Math.max(maxlen,j-i+1);
        }
        return maxlen;
    }
}