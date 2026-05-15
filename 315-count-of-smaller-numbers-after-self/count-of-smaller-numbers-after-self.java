class Solution {

    class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    int[] count;

    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;

        count = new int[n];

        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, 0, n - 1);

        List<Integer> ans = new ArrayList<>();

        for (int c : count) {
            ans.add(c);
        }

        return ans;
    }

    private void mergeSort(Pair[] arr, int left, int right) {

        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private void merge(Pair[] arr, int left, int mid, int right) {

        List<Pair> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;

        int rightCount = 0;

        while (i <= mid && j <= right) {

            if (arr[j].val < arr[i].val) {

                rightCount++;
                temp.add(arr[j++]);

            } else {

                count[arr[i].idx] += rightCount;
                temp.add(arr[i++]);
            }
        }

        while (i <= mid) {

            count[arr[i].idx] += rightCount;
            temp.add(arr[i++]);
        }

        while (j <= right) {
            temp.add(arr[j++]);
        }

        for (int k = left; k <= right; k++) {
            arr[k] = temp.get(k - left);
        }
    }
}