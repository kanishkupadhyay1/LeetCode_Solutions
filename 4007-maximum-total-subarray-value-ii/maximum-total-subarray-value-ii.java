class Solution {

    private int[][] stMax;
    private int[][] stMin;
    private int[] log;

    private long value(int l, int r) {
        int len = r - l + 1;
        int k = log[len];

        int mx = Math.max(stMax[k][l],
                          stMax[k][r - (1 << k) + 1]);

        int mn = Math.min(stMin[k][l],
                          stMin[k][r - (1 << k) + 1]);

        return (long) mx - mn;
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int m = log[n] + 1;

        stMax = new int[m][n];
        stMin = new int[m][n];

        for (int i = 0; i < n; i++) {
            stMax[0][i] = nums[i];
            stMin[0][i] = nums[i];
        }

        for (int j = 1; j < m; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                stMax[j][i] = Math.max(
                    stMax[j - 1][i],
                    stMax[j - 1][i + (1 << (j - 1))]
                );

                stMin[j][i] = Math.min(
                    stMin[j - 1][i],
                    stMin[j - 1][i + (1 << (j - 1))]
                );
            }
        }

        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));

        for (int l = 0; l < n; l++) {
            pq.offer(new long[]{
                value(l, n - 1), l, n - 1
            });
        }

        long ans = 0;

        while (k-- > 0) {
            long[] cur = pq.poll();

            long val = cur[0];
            int l = (int) cur[1];
            int r = (int) cur[2];

            ans += val;

            if (r > l) {
                pq.offer(new long[]{
                    value(l, r - 1), l, r - 1
                });
            }
        }

        return ans;
    }
}