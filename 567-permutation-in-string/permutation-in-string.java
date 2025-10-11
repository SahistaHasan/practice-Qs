class Solution {
    public boolean anagram(Map<Character,Integer> s1, Map<Character,Integer> s2){
        for(Map.Entry<Character,Integer> e:s1.entrySet()){
             if(!s2.containsKey(e.getKey())) return false;
             if(!e.getValue().equals(s2.get(e.getKey()))) return false;

        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
        }
        int i=0;
        for(int j=0;j<s2.length();j++){
            map.put(s2.charAt(j),map.getOrDefault(s2.charAt(j),0)+1);
            while(j-i+1>s1.length()){
                if(map.get(s2.charAt(i))==1) map.remove(s2.charAt(i));
                else map.put(s2.charAt(i),map.get(s2.charAt(i))-1);
                i++;
            }
            if(j-i+1==s1.length()){
                if(anagram(map1,map)) return true;
            }
        }
        return false;
    }
}