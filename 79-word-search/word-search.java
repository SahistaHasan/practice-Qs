class Solution {

    public boolean recurse(boolean[][] vis, char[][] board, int index, String word, int i, int j) {
        // Out of bounds
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        // Already visited
        if(vis[i][j]) return false;
        // Character mismatch
        if(board[i][j] != word.charAt(index)) return false;
        // Last character matched
        if(index == word.length() - 1) return true;

        // Mark visited
        vis[i][j] = true;

        // Explore 4 directions
        int[] drow = {0, 0, 1, -1};
        int[] dcol = {1, -1, 0, 0};

        for(int p = 0; p < 4; p++) {
            if(recurse(vis, board, index + 1, word, i + drow[p], j + dcol[p])) {
                return true;
            }
        }

        // Backtrack
        vis[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(recurse(vis, board, 0, word, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }
}
