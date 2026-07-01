class Solution {
    public int maxBuilding(int n, int[][] restrictions) {

        List<int[]> list = new ArrayList<>();

        list.add(new int[]{1, 0});

        for (int[] r : restrictions) {
            list.add(new int[]{r[0], r[1]});
        }

        boolean hasLast = false;
        for (int[] r : list) {
            if (r[0] == n) {
                hasLast = true;
                break;
            }
        }

        if (!hasLast) {
            list.add(new int[]{n, n - 1});
        }

        list.sort(Comparator.comparingInt(a -> a[0]));

        // Forward pass
        for (int i = 1; i < list.size(); i++) {
            int dist = list.get(i)[0] - list.get(i - 1)[0];
            list.get(i)[1] = Math.min(
                    list.get(i)[1],
                    list.get(i - 1)[1] + dist
            );
        }

        // Backward pass
        for (int i = list.size() - 2; i >= 0; i--) {
            int dist = list.get(i + 1)[0] - list.get(i)[0];
            list.get(i)[1] = Math.min(
                    list.get(i)[1],
                    list.get(i + 1)[1] + dist
            );
        }

        int ans = 0;

        for (int i = 1; i < list.size(); i++) {

            int x1 = list.get(i - 1)[0];
            int h1 = list.get(i - 1)[1];

            int x2 = list.get(i)[0];
            int h2 = list.get(i)[1];

            int dist = x2 - x1;

            ans = Math.max(ans,
                    (h1 + h2 + dist) / 2);
        }

        return ans;
    }
}