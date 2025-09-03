class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int i=0;
        int maxfreq=0;
        int maxlen=0;
        for(int j=0;j<answerKey.length();j++){
            map.put(answerKey.charAt(j),map.getOrDefault(answerKey.charAt(j),0)+1);
            maxfreq=Math.max(maxfreq,map.get(answerKey.charAt(j)));
            int valid=(j-i+1)-maxfreq;
            while(i< answerKey.length() && valid>k){
                map.put(answerKey.charAt(i),map.get(answerKey.charAt(i))-1);
                i++;
                valid=(j-i+1)-maxfreq;
            }
            maxlen=Math.max(maxlen,j-i+1);
        }
        return maxlen;
    }
}