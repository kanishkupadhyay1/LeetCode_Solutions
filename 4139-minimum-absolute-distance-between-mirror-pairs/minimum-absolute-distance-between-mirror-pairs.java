class Solution {

    public int reverse(int num){
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            
            if (map.containsKey(nums[i])) {
                min = Math.min(min, i - map.get(nums[i]));
            }

            int rev = reverse(nums[i]);
            map.put(rev, i);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}