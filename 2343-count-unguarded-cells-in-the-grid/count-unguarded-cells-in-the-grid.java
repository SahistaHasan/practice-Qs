import java.util.*;

class Solution {
    public void traverse(int i, int j, int[][] arr) {
        int m = arr.length, n = arr[0].length;

        // Move upward
        for (int r = i - 1; r >= 0; r--) {
            if (arr[r][j] == 1 || arr[r][j] == 0) break; // stop at wall or guard
            arr[r][j] = 2; // mark as guarded
        }

        // Move downward
        for (int r = i + 1; r < m; r++) {
            if (arr[r][j] == 1 || arr[r][j] == 0) break;
            arr[r][j] = 2;
        }

        // Move left
        for (int c = j - 1; c >= 0; c--) {
            if (arr[i][c] == 1 || arr[i][c] == 0) break;
            arr[i][c] = 2;
        }

        // Move right
        for (int c = j + 1; c < n; c++) {
            if (arr[i][c] == 1 || arr[i][c] == 0) break;
            arr[i][c] = 2;
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] arr = new int[m][n];
        // -1 = empty, 0 = guard, 1 = wall, 2 = guarded

        // Fill grid with -1
        for (int i = 0; i < m; i++) Arrays.fill(arr[i], -1);

        // Place guards
        for (int[] g : guards) arr[g[0]][g[1]] = 0;

        // Place walls
        for (int[] w : walls) arr[w[0]][w[1]] = 1;

        // Traverse from each guard
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    traverse(i, j, arr);
                }
            }
        }

        // Count unguarded cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == -1) count++;
            }
        }

        return count;
    }
}
