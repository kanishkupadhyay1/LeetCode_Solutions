class Solution {
    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n][n];

        // Base case: only one number left
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        // Fill DP table
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {

                int pickLeft = nums[i] - dp[i + 1][j];
                int pickRight = nums[j] - dp[i][j - 1];

                dp[i][j] = Math.max(pickLeft, pickRight);
            }
        }

        return dp[0][n - 1] >= 0;
    }
}