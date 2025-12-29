class Solution {

    boolean[] used;

    public boolean backtrack(int[] arr, int i, int n) {

        // move to next empty index
        while (i < arr.length && arr[i] != 0) i++;

        // all filled
        if (i == arr.length) return true;

        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;

            if (num == 1) {
                arr[i] = 1;
                used[1] = true;

                if (backtrack(arr, i + 1, n)) return true;

                arr[i] = 0;
                used[1] = false;
            } else {
                if (i + num < arr.length && arr[i + num] == 0) {
                    arr[i] = num;
                    arr[i + num] = num;
                    used[num] = true;

                    if (backtrack(arr, i + 1, n)) return true;

                    arr[i] = 0;
                    arr[i + num] = 0;
                    used[num] = false;
                }
            }
        }
        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int[] arr = new int[2 * n - 1];
        used = new boolean[n + 1];

        backtrack(arr, 0, n);
        return arr;
    }
}
