class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> que = new LinkedList<>();
         Set<String> visited = new HashSet<>();
        Set<String> map = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            map.add(wordList.get(i));
        }
        que.offer(beginWord);
        visited.add(beginWord);
        int count=1;
        while(!que.isEmpty()){
            int n=que.size();
            for(int p=0;p<n;p++){
            String curr=que.poll();
            for(int j=0;j<curr.length();j++){
                char c = curr.charAt(j);
            for(char i='a';i<='z';i++){
                
                StringBuilder sb = new StringBuilder(curr);
                sb.setCharAt(j,i);
                String changed = sb.toString();
                if(changed.equals(endWord) && map.contains(changed)) return count+1;
                if(map.contains(changed) && !visited.contains(changed)){
                    visited.add(changed);
                    que.offer(changed);
                    
                }

            }
            }
            }
            count++;
        }
        return 0;
    }
}