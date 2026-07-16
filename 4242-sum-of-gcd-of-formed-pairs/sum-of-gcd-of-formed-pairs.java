class Solution {

    public long gcdSum(int[] nums) {

        int n = nums.length;
        int[] prefix = new int[n];

        int mx = 0;

        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            prefix[i] = gcd(nums[i], mx);
        }

        Arrays.sort(prefix);

        long ans = 0;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            ans += gcd(prefix[left], prefix[right]);
            left++;
            right--;
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}