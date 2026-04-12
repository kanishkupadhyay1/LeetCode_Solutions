class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        int total = 0;

        // total cost using one finger
        for (int i = 1; i < n; i++) {
            total += dist(word.charAt(i - 1), word.charAt(i));
        }

        int[] dp = new int[26]; // savings
        int maxSave = 0;

        for (int i = 1; i < n; i++) {
            int b = word.charAt(i - 1) - 'A';
            int a = word.charAt(i) - 'A';

            int[] newDp = dp.clone();

            for (int c = 0; c < 26; c++) {
                int save = dist(b, a) - dist(c, a);
                newDp[b] = Math.max(newDp[b], dp[c] + save);
            }

            dp = newDp;
            maxSave = Math.max(maxSave, dp[b]);
        }

        return total - maxSave;
    }

    private int dist(char a, char b) {
        int x1 = (a - 'A') / 6, y1 = (a - 'A') % 6;
        int x2 = (b - 'A') / 6, y2 = (b - 'A') % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private int dist(int a, int b) {
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}