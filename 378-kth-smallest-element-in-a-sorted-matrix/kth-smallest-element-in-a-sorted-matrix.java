class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                que.offer(matrix[i][j]);
                while(que.size()>k){
                    que.poll();
                }
            }
        }
       
        return que.peek();
    }
}