class Solution {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<words.length;i++){
            set.add(words[i]);
        }
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();  
            }
            return a.compareTo(b);               
        });
        
        for(int i=0;i<words.length;i++){
            boolean found=true;
            for(int j=1;j<words[i].length();j++){
                String new_w = words[i].substring(0,j);
                if(!set.contains(new_w)){
                    found=false;
                    break;
                }
            }
           if(found==true) return words[i];
        }
        return "";
    }
}