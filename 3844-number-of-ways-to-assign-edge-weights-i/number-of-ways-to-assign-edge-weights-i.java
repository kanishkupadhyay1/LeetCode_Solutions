class Solution {
    private static final long MOD = 1_000_000_007L;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];

        q.offer(1);
        vis[1] = true;

        int depth = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            depth++;

            while (size-- > 0) {
                int node = q.poll();

                for (int nei : graph[node]) {
                    if (!vis[nei]) {
                        vis[nei] = true;
                        q.offer(nei);
                    }
                }
            }
        }

        return (int) modPow(2, depth - 1);
    }

    private long modPow(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }
}