// Binary Strings with Equal Sum of Two Halves
// Difficulty: MediumAccuracy: 41.34%Submissions: 25K+Points: 4Average Time: 20m
// Given a number n, find count of all binary sequences of length 2n such that sum of first n bits is same as sum of last n bits. 

// Note: Since the anwer can be very large, so return the answer modulo 109+7.


class Solution {
    static final long MOD = 1000000007L;

    private long power(long a, long b) {
        long res = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    public int computeValue(int n) {
        int N = 2 * n;

        long[] fact = new long[N + 1];
        long[] invFact = new long[N + 1];

        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        invFact[N] = power(fact[N], MOD - 2);

        for (int i = N - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }

        long ans = fact[N];
        ans = (ans * invFact[n]) % MOD;
        ans = (ans * invFact[n]) % MOD;

        return (int) ans;
    }
}