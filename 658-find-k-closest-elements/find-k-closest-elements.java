class Pair{
    int index;
    int dist;
    Pair(int index, int dist){
        this.index=index;
        this.dist=dist;
        }
        }
        class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> list = new ArrayList<>();
        PriorityQueue<Pair> que = new PriorityQueue<>((a, b) -> a.dist == b.dist ? arr[a.index] - arr[b.index] : a.dist - b.dist);
        for(int i=0;i<arr.length;i++){
            que.offer(new Pair(i,Math.abs(x-arr[i])));
        }
        while(k!=0){
            list.add(arr[que.poll().index]);
            k--;
        }
        Collections.sort(list);
        return list;

    }
}