class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int[][] res=new int[grid.length][grid[0].length];
        for(int i=1;i<grid.length;i++){
            List<Integer> inner=new ArrayList<>();
            int j=0;
            for( j=i;j<grid.length;j++){
                
                inner.add(grid[j-i][j]);
                
                
            }
            Collections.sort(inner);
            j=i;
            int count=0;
            for(j=i;j<grid.length;j++){
              res[j-i][j]=inner.get(count);
              count++;
            }

        }
        for(int i=0;i<grid.length;i++){
            List<Integer> inner = new ArrayList<>();
            int j=0;
            for( j=i;j<grid.length;j++){
                inner.add(grid[j][j-i]);
                
                
            }
           Collections.sort(inner, Collections.reverseOrder());
            j=i;
            int count=0;
            for(j=i;j<grid.length;j++){
                res[j][j-i]=inner.get(count);
                count++;
            }
        }
        return res;
    }
}