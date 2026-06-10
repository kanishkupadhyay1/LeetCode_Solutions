class Solution {
    public boolean canJump(int[] nums) {
        int j=0,e=0,f=0;
        for(int i=00;i<nums.length;i++){
            if(i>f) return false;

            f=Math.max(f,i+nums[i]);
           
            
        }
        return true;
    }
}



















