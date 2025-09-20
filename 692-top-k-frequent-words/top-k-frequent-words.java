class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b)-> {
             if (a.getValue().equals(b.getValue())) {
                    return a.getKey().compareTo(b.getKey()); // lexicographic
                }
           return b.getValue()-a.getValue();
    }); 
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
            
        }
        for (Map.Entry<String,Integer> e:map.entrySet()){
           pq.offer(e);
        }
        List<String> list = new ArrayList<>();
        while(k!=0){
            list.add(pq.poll().getKey());
            k--;
        }
       
        return list;

    }
}