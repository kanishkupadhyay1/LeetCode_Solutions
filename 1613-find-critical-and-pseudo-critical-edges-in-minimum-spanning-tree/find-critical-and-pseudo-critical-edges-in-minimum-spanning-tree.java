import java.util.*;

class Solution {

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;
            parent[pa] = pb;
            return true;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

        int m = edges.length;

        // add index to edges
        int[][] newEdges = new int[m][4];
        for (int i = 0; i < m; i++) {
            newEdges[i] = new int[]{edges[i][0], edges[i][1], edges[i][2], i};
        }

        Arrays.sort(newEdges, (a, b) -> a[2] - b[2]);

        int baseCost = kruskal(n, newEdges, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            
            if (kruskal(n, newEdges, i, -1) > baseCost) {
                critical.add(newEdges[i][3]);
            }
           
            else if (kruskal(n, newEdges, -1, i) == baseCost) {
                pseudo.add(newEdges[i][3]);
            }
        }

        return Arrays.asList(critical, pseudo);
    }

    private int kruskal(int n, int[][] edges, int skip, int pick) {
        DSU dsu = new DSU(n);
        int cost = 0;

        // force edge first
        if (pick != -1) {
            dsu.union(edges[pick][0], edges[pick][1]);
            cost += edges[pick][2];
        }

        for (int i = 0; i < edges.length; i++) {
            if (i == skip) continue;

            if (dsu.union(edges[i][0], edges[i][1])) {
                cost += edges[i][2];
            }
        }

        // check if all connected
        int root = dsu.find(0);
        for (int i = 1; i < n; i++) {
            if (dsu.find(i) != root) return Integer.MAX_VALUE;
        }

        return cost;
    }
}