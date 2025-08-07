class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder sb = new StringBuilder();
        int cycle = 2 * (numRows - 1);

        for (int i = 0; i < numRows; i++) {
            int j = i;
            while (j < s.length()) {
                if (i == 0 || i == numRows - 1) {
                    // first and last row
                    sb.append(s.charAt(j));
                } else {
                    // middle rows: vertical
                    sb.append(s.charAt(j));
                    
                    // middle rows: diagonal
                    int diag = j + cycle - 2 * i;
                    if (diag < s.length()) {
                        sb.append(s.charAt(diag));
                    }
                }
                j += cycle;
            }
        }
        return sb.toString();
    }
}
