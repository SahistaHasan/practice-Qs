import java.util.Arrays;

class Solution {
    static final int MOD = 1_000_000_007;

    public int recurse(int target, int x, int index, int[][] dp) {
        if (target == 0) return 1;
        if (target < 0 || index == 0) return 0;

        if (dp[target][index] != -1) return dp[target][index];

        int power = (int) Math.pow(index, x);

        int ways = recurse(target, x, index - 1, dp);

        if (power <= target) {
            ways = (ways + recurse(target - power, x, index - 1, dp)) % MOD;
        }

        dp[target][index] = ways;
        return ways;
    }

    public int numberOfWays(int n, int x) {
        int maxBase = 1;
        while (Math.pow(maxBase, x) <= n) {
            maxBase++;
        }
        maxBase--;

        int[][] dp = new int[n + 1][maxBase + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return recurse(n, x, maxBase, dp);
    }
}
