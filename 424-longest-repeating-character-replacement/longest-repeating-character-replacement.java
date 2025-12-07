class Solution {
    public int max(Map<Character,Integer> map){
        int max=0;
        for(Map.Entry<Character,Integer> e:map.entrySet()){
            max=Math.max(max,e.getValue());
        }
        return max;

    }
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i=0;
        int valid=0;
        int maxfreq=0;
        int maxlen=0;
        for(int j=0;j<s.length();j++){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            maxfreq=max(map);
            valid=(j-i+1)-maxfreq;
            while(i<s.length() && k<valid){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                maxfreq=max(map);
                i++;
                valid=j-i+1-maxfreq;
            }
            maxlen=Math.max(maxlen,j-i+1);
        }
        return maxlen;
    }
}