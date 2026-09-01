class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        // dp[i] = maximum score difference
        // current player can achieve starting from i.
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MIN_VALUE;

            int sum = 0;

            // Take 1, 2, or 3 stones
            for (int k = 1; k <= 3 && i + k <= n; k++) {
                sum += stoneValue[i + k - 1];

                dp[i] = Math.max(
                    dp[i],
                    sum - dp[i + k]
                );
            }
        }

        if (dp[0] > 0)
            return "Alice";
        else if (dp[0] < 0)
            return "Bob";
        else
            return "Tie";
    }
}