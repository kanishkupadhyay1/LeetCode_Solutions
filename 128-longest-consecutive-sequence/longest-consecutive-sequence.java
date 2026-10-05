class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        int length=1;
        int ans=1;
        Arrays.sort(nums);

        int i=1;
        while(i<nums.length){

            if (nums[i] == nums[i - 1]) {
                // Duplicate → ignore
                i++;
                continue;
            }
            if(nums[i]==nums[i-1]+1){
                length++;
            }else{
                ans=Math.max(ans,length);
                length=1;
            }
            i++;
        }
       ans= Math.max(ans,length);
    return ans;
    }
}