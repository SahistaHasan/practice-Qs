class Solution {
    public boolean anagram(String s1, String s2){
        if(s1.length()!=s2.length()) return false;
        char[] chars = s1.toCharArray();

        // Sort the array
        Arrays.sort(chars);

        // Convert back to string
        String sorted1 = new String(chars);
         char[] chars2 = s2.toCharArray();

        // Sort the array
        Arrays.sort(chars2);

        // Convert back to string
        String sorted2 = new String(chars2);
        if(!sorted1.equals(sorted2)) return false;

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