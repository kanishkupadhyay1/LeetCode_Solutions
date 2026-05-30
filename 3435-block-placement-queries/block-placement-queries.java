class Solution {
    class Fenwick {
        int[] tree;

        Fenwick(int n) {
            tree = new int[n + 1];
        }

        void update(int i, int val) {
            while (i < tree.length) {
                tree[i] = Math.max(tree[i], val);
                i += i & -i;
            }
        }

        int query(int i) {
            int res = 0;
            while (i > 0) {
                res = Math.max(res, tree[i]);
                i -= i & -i;
            }
            return res;
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        int mx = 0;

        for (int[] q : queries) {
            mx = Math.max(mx, q[1]);
        }

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(mx + 1);

        for (int[] q : queries) {
            if (q[0] == 1) {
                obstacles.add(q[1]);
            }
        }

        Fenwick bit = new Fenwick(mx + 5);

        Integer prev = null;
        for (int x : obstacles) {
            if (prev != null) {
                bit.update(x, x - prev);
            }
            prev = x;
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];

            if (q[0] == 2) {
                int x = q[1];
                int sz = q[2];

                Integer p = obstacles.floor(x);

                int best = bit.query(p);
                best = Math.max(best, x - p);

                ans.add(best >= sz);
            } else {
                int x = q[1];

                int l = obstacles.lower(x);
                int r = obstacles.higher(x);

                obstacles.remove(x);
                bit.update(r, r - l);
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}