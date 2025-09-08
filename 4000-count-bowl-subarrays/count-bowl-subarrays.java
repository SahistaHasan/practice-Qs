import java.util.*;

public class Solution {

    // Function to find the next greater or equal element to the left
    private int[] nextGeqLeft(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }

    // Function to find the next greater or equal element to the right
    private int[] nextGeqRight(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }

    public long bowlSubarrays(int[] nums) {
        int n = nums.length;
        int[] geql = nextGeqLeft(nums);
        int[] geqr = nextGeqRight(nums);

        long cnt = 0;
        for (int i = 0; i < n; i++) {
            if (geql[i] != -1 && geql[i] < i - 1) cnt++;
            if (geqr[i] != -1 && geqr[i] > i + 1) cnt++;
        }
        return cnt;
    }
}