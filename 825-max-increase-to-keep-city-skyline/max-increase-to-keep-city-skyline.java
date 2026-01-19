class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] right =new int [grid.length];
       
        int [] up = new int[grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                right[i]=Math.max(grid[i][j],right[i]);
                up[j]=Math.max(grid[i][j],up[j]);
            }
        }
        int sum=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                sum=sum+Math.abs(grid[i][j]-Math.min(right[i],up[j]));
                
            }
        }
        return sum;
    }
}