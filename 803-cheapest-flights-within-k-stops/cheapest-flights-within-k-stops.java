class Pair {
    int node;
    int cost;
    Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class Tuple {
    int stops, node, cost;
    Tuple(int stops, int node, int cost) {
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // Adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        // Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        // Queue -> BFS style {stops, node, cost}
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            int stops = t.stops;
            int node = t.node;
            int cost = t.cost;

            // If stop limit exceeded, skip
            if (stops > K) continue;

            for (Pair next : adj.get(node)) {
                int adjNode = next.node;
                int newCost = cost + next.cost;

                if (newCost < dist[adjNode] && stops <= K) {
                    dist[adjNode] = newCost;
                    q.add(new Tuple(stops + 1, adjNode, newCost));
                }
            }
        }

        return dist[dst] == (int) 1e9 ? -1 : dist[dst];
    }
}
    