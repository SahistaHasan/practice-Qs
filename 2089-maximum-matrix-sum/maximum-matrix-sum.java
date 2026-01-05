class Solution {
    public long maxMatrixSum(int[][] matrix) {
       long abssum=0;
       int count=0;
       int min=Integer.MAX_VALUE;
       for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[i][j]<0) count++;
            abssum=abssum+Math.abs(matrix[i][j]);
            min=Math.min(min,Math.abs(matrix[i][j]));
        }

       } 
       if(count%2==0) return abssum;
       else return abssum-2*min;
    }
}