class Solution {
    public int uniqueXorTriplets(int[] nums) {

        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }

        mx <<= 1;

        boolean[] pair = new boolean[mx];

        // All pair XORs
        for (int a : nums) {
            for (int b : nums) {
                pair[a ^ b] = true;
            }
        }

        boolean[] triplet = new boolean[mx];

        // Pair XOR ^ third element
        for (int x = 0; x < mx; x++) {
            if (!pair[x]) continue;

            for (int c : nums) {
                triplet[x ^ c] = true;
            }
        }

        int ans = 0;
        for (boolean b : triplet) {
            if (b) ans++;
        }

        return ans;
    }
}