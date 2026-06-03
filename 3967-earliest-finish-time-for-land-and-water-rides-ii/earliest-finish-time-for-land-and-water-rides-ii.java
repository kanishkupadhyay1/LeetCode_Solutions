class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(
                solve(landStartTime, landDuration,
                      waterStartTime, waterDuration),
                solve(waterStartTime, waterDuration,
                      landStartTime, landDuration)
        );
    }

    private int solve(
            int[] s1, int[] d1,
            int[] s2, int[] d2) {

        int m = s2.length;

        int[][] rides = new int[m][2];
        for (int i = 0; i < m; i++) {
            rides[i][0] = s2[i];
            rides[i][1] = d2[i];
        }

        Arrays.sort(rides, (a, b) -> a[0] - b[0]);

        int[] starts = new int[m];
        int[] pref = new int[m];
        int[] suff = new int[m];

        for (int i = 0; i < m; i++) {
            starts[i] = rides[i][0];
        }

        pref[0] = rides[0][1];
        for (int i = 1; i < m; i++) {
            pref[i] = Math.min(pref[i - 1], rides[i][1]);
        }

        suff[m - 1] = rides[m - 1][0] + rides[m - 1][1];
        for (int i = m - 2; i >= 0; i--) {
            suff[i] = Math.min(
                    suff[i + 1],
                    rides[i][0] + rides[i][1]
            );
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < s1.length; i++) {

            int finish = s1[i] + d1[i];

            int idx = upperBound(starts, finish) - 1;

            if (idx >= 0) {
                ans = Math.min(ans, finish + pref[idx]);
            }

            if (idx + 1 < m) {
                ans = Math.min(ans, suff[idx + 1]);
            }
        }

        return ans;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}