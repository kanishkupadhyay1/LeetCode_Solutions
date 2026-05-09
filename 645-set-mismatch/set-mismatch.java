class Solution {
    public int[] findErrorNums(int[] nums) {

        int[] ans = new int[2];

        Set<Integer> set = new HashSet<>();

        int duplicate = -1;
        int missing = -1;

        for (int num : nums) {
            if (set.contains(num)) {
                duplicate = num;
            }
            set.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }

        ans[0] = duplicate;
        ans[1] = missing;

        return ans;
    }
}