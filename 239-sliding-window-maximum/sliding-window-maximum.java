class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] arr = new int[nums.length-k+1];
        int idx=0;
        Deque<Integer> que = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            while(!que.isEmpty() && que.peek()<=i-k){
                que.poll();
            }
            while(!que.isEmpty() && nums[que.peekLast()]<=nums[i]){
                que.pollLast();
            }
             que.offer(i);
            if(i>=k-1){
            
            arr[idx]=nums[que.peek()];
            idx++;
            }
        }
        return arr;
    }
}