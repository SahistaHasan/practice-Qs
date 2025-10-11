class Solution {
    public boolean anagram(Map<Character,Integer> p1, Map<Character,Integer> s1){
        for(Map.Entry<Character,Integer> e:p1.entrySet()){
            if(!s1.containsKey(e.getKey())) return false;
            if(!e.getValue().equals(s1.get(e.getKey()))) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map=new HashMap<>();
       List<Integer> list = new ArrayList<>();
        for(int i=0;i<p.length();i++){
            map1.put(p.charAt(i),map1.getOrDefault(p.charAt(i),0)+1);
        }
        int i=0;
        for(int j=0;j<s.length();j++){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            while(j-i+1>p.length()){
                
                if(map.get(s.charAt(i))==1) map.remove(s.charAt(i));
                else map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
            }
            if(j-i+1==p.length()){
                if(anagram(map1,map)){
                    list.add(i);
                }
            }
           
        }
        return list;
    }
}