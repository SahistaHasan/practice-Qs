class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] vis = new boolean[rooms.size()];
        Queue<Integer> que = new LinkedList<>();
        que.offer(0);
        vis[0]=true;
        while(!que.isEmpty()){
            int curr=que.poll();
            for(int room:rooms.get(curr)){
                if(vis[room]==false){
                vis[room]=true;
                que.offer(room);
                }
            }
        }
        for(int i=0;i<vis.length;i++){
            if(vis[i]==false) return false;
        }
        return true;
    }
}