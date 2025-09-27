import java.util.*;

class Pair {
    int[] node;
    int dist;

    Pair(int[] node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // If start or end is blocked
        if (grid[0][0] != 0 || grid[rows - 1][cols - 1] != 0) return -1;

        int[][] dist = new int[rows][cols];
        for (int i = 0; i < rows; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        dist[0][0] = 1; // starting cell counts as step 1

        int[] drow = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] dcol = {1, -1, 0, 1, -1, 0, 1, -1};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(new int[]{0, 0}, 1));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.node[0];
            int y = p.node[1];
            int d = p.dist;

            for (int i = 0; i < 8; i++) {
                int nx = x + drow[i];
                int ny = y + dcol[i];

                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && grid[nx][ny] == 0) {
                    if (dist[nx][ny] > d + 1) {
                        dist[nx][ny] = d + 1;
                        q.add(new Pair(new int[]{nx, ny}, dist[nx][ny]));
                    }
                }
            }
        }

        return dist[rows - 1][cols - 1] == Integer.MAX_VALUE ? -1 : dist[rows - 1][cols - 1];
    }
}
