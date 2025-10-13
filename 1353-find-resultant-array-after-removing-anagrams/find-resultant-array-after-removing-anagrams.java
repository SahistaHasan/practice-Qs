class Solution {
    public boolean anagram(String s1, String s2){
        if(s1.length()!=s2.length()) return false;
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2= new HashMap<>();
        for(int i=0;i<s1.length();i++){
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
            map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0)+1);
        }
        for(Map.Entry<Character,Integer> e:map1.entrySet()){
            if(!map2.containsKey(e.getKey())) return false;
            if(!e.getValue().equals(map2.get(e.getKey()))) return false;
        }
        return true;
    }
    public List<String> removeAnagrams(String[] words) {
        int i=0;
        List<String> list = new ArrayList<>();
        for(int j=1;j<words.length;j++){
            if(anagram(words[i],words[j])){
                continue;
            }
            else{
              if(list.isEmpty() || list.get(list.size()-1)!=words[i]){
                list.add(words[i]);
              }
                list.add(words[j]);
                i=j;
            }
        }
        if(list.size()==0) list.add(words[0]);
        return list;
    }
}