class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int n = difficulty.length;
        int[][] jobs = new int[n][2];

        // combine arrays
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        // sort by difficulty
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // prefix max profits
        int[] best = new int[n];
        best[0] = jobs[0][1];

        for (int i = 1; i < n; i++) {
            best[i] = Math.max(best[i - 1], jobs[i][1]);
        }

        int sum = 0;

        // binary search for every worker
        for (int w : worker) {
            int low = 0, high = n - 1, ans = -1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (jobs[mid][0] <= w) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (ans != -1)
                sum += best[ans];
        }

        return sum;
    }
}
