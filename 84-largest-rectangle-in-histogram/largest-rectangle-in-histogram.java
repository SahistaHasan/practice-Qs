class Solution {
    public int largestRectangleArea(int[] heights) {
        int [] nse = new int[heights.length];
        int [] pse = new int[heights.length];
        Stack<Integer> ns = new Stack<>();
        Stack<Integer> ps = new Stack<>();
        for(int i=heights.length-1;i>=0;i--){
            while(!ns.isEmpty() && heights[i]<=heights[ns.peek()]){
                ns.pop();
            }
            if(ns.isEmpty()) nse[i]=heights.length;
            else nse[i]=ns.peek();
            ns.push(i);
        }
        for(int i=0;i<heights.length;i++){
            while(!ps.isEmpty() && heights[i]<=heights[ps.peek()]){
                  ps.pop();
            }
            if(ps.isEmpty()) pse[i]=-1;
            else pse[i]=ps.peek();
            ps.push(i);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            max=Math.max(heights[i]*(nse[i]-pse[i]-1),max);
        }
        return max;
    }
}