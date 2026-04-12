class Solution {
    Integer[][][] dp;

    public int minimumDistance(String word) {
        dp = new Integer[27][27][word.length()];
        return solve(word, 26, 26, 0);
    }

    private int solve(String word, int f1, int f2, int i) {
        if (i == word.length()) return 0;

        if (dp[f1][f2][i] != null)
            return dp[f1][f2][i];

        int curr = word.charAt(i) - 'A';

        int useF1 = dist(f1, curr) + solve(word, curr, f2, i + 1);
        int useF2 = dist(f2, curr) + solve(word, f1, curr, i + 1);

        return dp[f1][f2][i] = Math.min(useF1, useF2);
    }

    private int dist(int a, int b) {
        if (a == 26) return 0;
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}