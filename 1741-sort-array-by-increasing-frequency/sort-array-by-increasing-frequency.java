class Solution {
    public int[] frequencySort(int[] nums) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Integer[] arr = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> {

            int freqA = freq.get(a);
            int freqB = freq.get(b);

            if (freqA != freqB) {
                return freqA - freqB;
            }

            return b - a;
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
}