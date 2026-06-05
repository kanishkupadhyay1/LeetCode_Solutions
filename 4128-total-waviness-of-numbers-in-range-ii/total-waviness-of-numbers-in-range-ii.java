class Solution {
    char[] s;
    Long[][][][] dp;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x <= 5) return 0;
        s = String.valueOf(x).toCharArray();
        dp = new Long[s.length][11][11][2];
        return dfs(0, 10, 10, 0, true);
    }

    private long dfs(int pos, int a, int b, int started, boolean tight) {
        if (pos == s.length) return 0;

        if (!tight && dp[pos][a][b][started] != null)
            return dp[pos][a][b][started];

        int lim = tight ? s[pos] - '0' : 9;
        long ans = 0;

        for (int d = 0; d <= lim; d++) {
            boolean nt = tight && d == lim;

            if (started == 0 && d == 0) {
                ans += dfs(pos + 1, 10, 10, 0, nt);
            } else if (started == 0) {
                ans += dfs(pos + 1, 10, d, 1, nt);
            } else if (a == 10) {
                ans += dfs(pos + 1, b, d, 1, nt);
            } else {
                long add = ((a < b && b > d) || (a > b && b < d)) ? 1 : 0;
                ans += add * suffixCount(pos + 1, nt);
                ans += dfs(pos + 1, b, d, 1, nt);
            }
        }

        if (!tight) dp[pos][a][b][started] = ans;
        return ans;
    }

    private long suffixCount(int pos, boolean tight) {
        if (!tight) return (long) Math.pow(10, s.length - pos);

        long rem = 0;
        for (int i = pos; i < s.length; i++)
            rem = rem * 10 + (s[i] - '0');
        return rem + 1;
    }
}