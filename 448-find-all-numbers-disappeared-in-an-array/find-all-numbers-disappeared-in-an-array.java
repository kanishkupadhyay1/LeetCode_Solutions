class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        Set<Integer> s = new HashSet<>();

        for (int num : nums) {
            s.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!s.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}