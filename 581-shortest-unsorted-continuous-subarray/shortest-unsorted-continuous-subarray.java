class Solution {

    public int findUnsortedSubarray(int[] nums) {

        int[] sorted = nums.clone();

        Arrays.sort(sorted);

        int start = 0;
        int end = nums.length - 1;

        while (start < nums.length && nums[start] == sorted[start]) {
            start++;
        }

        while (end > start && nums[end] == sorted[end]) {
            end--;
        }

        return end - start + 1;
    }
}