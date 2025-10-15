class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
           while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                int nse = i;
                int popped_idx = stack.pop();
                int pse = stack.isEmpty()?-1:stack.peek();

                res = Math.max(res,heights[popped_idx]*(nse-pse-1));

           }
           stack.push(i);
        }
        while(!stack.isEmpty()){
            int nse=heights.length;
            int popped_index=stack.pop();
            int pse=stack.isEmpty()?-1:stack.peek();
            res=Math.max(res,heights[popped_index]*(nse-pse-1));
        }
        return res;
    }
}