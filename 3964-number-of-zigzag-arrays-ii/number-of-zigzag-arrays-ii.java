class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) return m;

        int S = 2 * m;

        long[][] T = new long[S][S];

        

        for (int v = 0; v < m; v++) {

            for (int u = 0; u < v; u++) {
                T[v][m + u] = 1;
            }

            for (int u = v + 1; u < m; u++) {
                T[m + v][u] = 1;
            }
        }

        long[][] P = matPow(T, n - 1);

        long[] init = new long[S];

        for (int i = 0; i < S; i++) {
            init[i] = 1;
        }

        long ans = 0;

        for (int i = 0; i < S; i++) {
            long ways = 0;

            for (int j = 0; j < S; j++) {
                ways = (ways + P[i][j] * init[j]) % MOD;
            }

            ans = (ans + ways) % MOD;
        }

        return (int) ans;
    }

    private long[][] matPow(long[][] base, long exp) {
        int n = base.length;

        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }

            base = multiply(base, base);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;

        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {

                if (A[i][k] == 0) continue;

                long a = A[i][k];

                for (int j = 0; j < n; j++) {

                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j] + a * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }
}