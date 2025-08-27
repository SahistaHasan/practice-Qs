class Pair {
    int x;
    int y;
    int radius;
    int index; // to track which bomb it is
    Pair(int x, int y, int radius, int index) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.index = index;
    }
}

class Solution {
    public int bfs(int start, int[][] bombs, boolean[] vis) {
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(bombs[start][0], bombs[start][1], bombs[start][2], start));
        vis[start] = true;
        int count = 1;

        while (!que.isEmpty()) {
            Pair cur = que.poll();
            int x = cur.x;
            int y = cur.y;
            int r = cur.radius;

            for (int i = 0; i < bombs.length; i++) {
                if (!vis[i]) {
                    long dx = x - bombs[i][0];
                    long dy = y - bombs[i][1];
                    if (dx * dx + dy * dy <= (long) r * r) { // correct distance check
                        que.offer(new Pair(bombs[i][0], bombs[i][1], bombs[i][2], i));
                        vis[i] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int maximumDetonation(int[][] bombs) {
        int max = 0;
        for (int i = 0; i < bombs.length; i++) {
            boolean[] vis = new boolean[bombs.length]; // fresh vis for each start
            max = Math.max(max, bfs(i, bombs, vis));
        }
        return max;
    }
}
