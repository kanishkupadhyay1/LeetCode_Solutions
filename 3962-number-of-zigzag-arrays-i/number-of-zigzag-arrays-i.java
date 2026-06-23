class Solution {
    public int zigZagArrays(int n, int l, int r) {
        final int MOD = 1_000_000_007;

        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        for (int i = 0; i < m; i++) {
            up[i] = 1;
            down[i] = 1;
        }

        for (int len = 2; len <= n; len++) {

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            long[] prefUp = new long[m + 1];
            long[] prefDown = new long[m + 1];

            for (int i = 0; i < m; i++) {
                prefUp[i + 1] = (prefUp[i] + up[i]) % MOD;
                prefDown[i + 1] = (prefDown[i] + down[i]) % MOD;
            }

            long totalUp = prefUp[m];
            long totalDown = prefDown[m];

            for (int v = 0; v < m; v++) {

                newUp[v] = prefDown[v] % MOD;

                newDown[v] =
                        (totalUp - prefUp[v + 1] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}