class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int index, int target, int[] candidates,
                           List<Integer> curr, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (index == candidates.length || target < 0) {
            return;
        }

        curr.add(candidates[index]);
        backtrack(index, target - candidates[index], candidates, curr, ans);
        curr.remove(curr.size() - 1);

        backtrack(index + 1, target, candidates, curr, ans);
    }
}