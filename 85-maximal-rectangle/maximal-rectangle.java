class Solution {
    public int hist(int [] heights){
        Stack<Integer> stack = new Stack<>();
        int max=0;
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
              int nse=i;
              int poppedindex=stack.pop();
              int pse;
              if(stack.isEmpty()) pse=-1;
              else pse=stack.peek();
              max=Math.max(max,heights[poppedindex]*(nse-pse-1));
              
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int nse=heights.length;
            int poppedindex=stack.pop();
            int pse;
            if(stack.isEmpty()) pse=-1;
            else pse=stack.peek();
            max=Math.max(max,heights[poppedindex]*(nse-pse-1));
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int [][] presum = new int[matrix.length][matrix[0].length];
        
        for(int i=0;i<matrix[0].length;i++){
            int sum=0;
            for(int j=0;j<matrix.length;j++){
                 
                 if(matrix[j][i]=='0') sum=0;
                 sum=sum+(matrix[j][i]-'0');
                 presum[j][i]=sum;
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<presum.length;i++){
            max=Math.max(max,hist(presum[i]));
        }
        return max;
    }
}