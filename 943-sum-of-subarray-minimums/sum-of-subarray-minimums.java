class Solution {
    public void nse(int[] nsearr,int []arr){
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()) nsearr[i]=arr.length;
            else{
                nsearr[i]=stack.peek();
            }
            stack.push(i);

        }
    }
    public void pse(int[] psearr, int[] arr){
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()) psearr[i]=-1;
            else{
                psearr[i]=stack.peek();
            }
            stack.push(i);
        }
    }
    public int sumSubarrayMins(int[] arr) {
        int[] nse = new int[arr.length];
        nse(nse,arr);
        int[] pse= new int[arr.length];
        pse(pse,arr);
        long sum=0;
        int mod=(int)Math.pow(10,9)+7;
        for(int i=0;i<arr.length;i++){
           long left = i - pse[i];       // distance to previous smaller
            long right = nse[i] - i;      // distance to next smaller
            long contri = ((arr[i] % mod) * left % mod) * right % mod;
            sum = (sum + contri) % mod;
        }
        return (int)sum;
    }
}