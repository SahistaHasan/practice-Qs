class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int vowel=0;
        int conso=0;
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u' ){
                vowel=Math.max(vowel,map.get(s.charAt(i)));
            }
            else{
                conso=Math.max(conso,map.get(s.charAt(i)));
            }
        }
        return vowel+conso;
    }
}