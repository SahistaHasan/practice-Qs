import java.util.*;

class Pair {
    int node;
    int dist;
    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    List<List<Pair>> adj = new ArrayList<>();

    public int[] dijkstra(int n,int start, int[][] edges, int thresh) {
        PriorityQueue<Pair> que = new PriorityQueue<>((a,b)->a.dist-b.dist);
        int [] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;
        que.offer(new Pair(start, 0));

        while (!que.isEmpty()) {
            Pair p = que.poll();
            for (Pair next : adj.get(p.node)) {
                int newDist = p.dist + next.dist;
                if (newDist <= thresh && dist[next.node]>newDist) {
                    que.offer(new Pair(next.node, newDist));
                    
                    dist[next.node] = newDist;

                }
            }
        }
        return dist;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(new Pair(e[1], e[2]));
            adj.get(e[1]).add(new Pair(e[0], e[2]));
        }

        
        int minReachable = Integer.MAX_VALUE;
        int resultCity = -1;

        for (int i = 0; i < n; i++) {
            List<Pair> inn = new ArrayList<>();
           int[] dist = dijkstra(n,i, edges, distanceThreshold);
            int reachable = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[j] <= distanceThreshold) {
                    reachable++;
                }
            }

            // smallest reachable wins, ties -> larger city index
            if (reachable <= minReachable) {
                minReachable = reachable;
                resultCity = i;
            }
        
        }
        return resultCity;
    }
}
