class Solution {
    public int power(int base, long pow) {
        int MOD = 1000000007;
        long ans = 1;
        long b = base ;

        while (pow != 0) {
            if (pow % 2 == 0) {
                pow = pow / 2;
                b = (b * b) % MOD;
            } else {
                pow = pow - 1;
                ans = (ans * b) % MOD;
            }
        }
        return (int) ans;
    }

    public int countGoodNumbers(long n) {
        int MOD = 1000000007;
        long odd = n / 2;
        long even = (n + 1) / 2;   

        long part1 = power(5, even);
        long part2 = power(4, odd);

        long ans = (part1 * part2) % MOD; 
        return (int) ans;
    }
}
