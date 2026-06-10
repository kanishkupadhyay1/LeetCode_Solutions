class Solution {
    public int jump(int[] nums) {
        int st=0,ed=0,f=0;
        for(int i=0;i<nums.length-1;i++){
            f=Math.max(f,i+nums[i]);
            if(i==ed){
                st++;
    ed=f;
            }
        }
        return st;
    }
}