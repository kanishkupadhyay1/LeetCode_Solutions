class Solution {
    public int findLucky(int[] arr) {

        Map<Integer, Integer> mp = new HashMap<>();

        for(int x : arr) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }

        int ans = -1;

        for(int key : mp.keySet()) {

            if(key == mp.get(key)) {
                ans = Math.max(ans, key);
            }
        }

        return ans;
    }
}