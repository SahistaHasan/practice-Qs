class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int j=0;
        int count=0;
        int i=k-1;
        int [] arr = new int[nums.length-k+1];
        for(i=k-1;i<nums.length;i++){
           PriorityQueue<Map.Entry<Integer,Integer>> que = new PriorityQueue<>((a,b)->{ if (!a.getValue().equals(b.getValue())) {
                    
                    return b.getValue() - a.getValue();
                } else {
                    
                    return b.getKey() - a.getKey();
                }
            });
            Map<Integer,Integer> map=new HashMap<>();
           for(int p=j;p<=i;p++){
            map.put(nums[p],map.getOrDefault(nums[p],0)+1);
           }
           que.addAll(map.entrySet());
           for(int p=0;p<x && !que.isEmpty();p++){
             Map.Entry<Integer, Integer> e = que.poll();
                arr[count] += e.getKey() * e.getValue();
           }
           count++;
           j++;



        }
        return arr;
    }
}