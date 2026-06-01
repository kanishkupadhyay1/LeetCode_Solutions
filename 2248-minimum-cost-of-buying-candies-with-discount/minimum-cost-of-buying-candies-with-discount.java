class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int total = 0;
        int cnt = 0;

        for (int i = cost.length - 1; i >= 0; i--) {
            cnt++;

            if (cnt % 3 != 0) {
                total += cost[i];
            }
        }

        return total;
    }
}