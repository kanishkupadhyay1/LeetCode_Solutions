class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        Fenwick bit = new Fenwick(n + 2);

        long ans = 0;

        for (int x : prefix) {
            int idx = lowerBound(sorted, x) + 1;

            ans += bit.query(idx - 1);

            bit.add(idx, 1);
        }

        return (int) ans;
    }

    private int lowerBound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (a[mid] >= x)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 1];
        }

        void add(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }
}