class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        int lo = Integer.MAX_VALUE, hi = 0;

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            if ((u != 0 && u != n - 1 && !online[u]) ||
                (v != 0 && v != n - 1 && !online[v]))
                continue;

            graph[u].add(new int[]{v, w});
            lo = Math.min(lo, w);
            hi = Math.max(hi, w);
        }

        if (lo == Integer.MAX_VALUE) return -1;

        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(graph, n, k, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(List<int[]>[] graph, int n, long k, int limit) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        dist[0] = 0;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u = (int) cur[0];
            long d = cur[1];

            if (d != dist[u]) continue;
            if (d > k) continue;
            if (u == n - 1) return true;

            for (int[] e : graph[u]) {
                int v = e[0], w = e[1];
                if (w < limit) continue;

                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.offer(new long[]{v, dist[v]});
                }
            }
        }

        return false;
    }
}