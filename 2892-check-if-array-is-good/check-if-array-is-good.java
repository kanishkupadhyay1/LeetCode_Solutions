class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int max=nums[nums.length-1];

        if(nums.length>max+1)return false;

        Map<Integer,Integer> mp=new HashMap<>();
        for(int x: nums){
            mp.put(x,mp.getOrDefault(x,0)+1);
        }

    if(mp.get(max)==2){
        for(int i=1;i<max;i++){
            if(mp.getOrDefault(i,0)<1)return false;
        }
    }else return false;
        
        return true;
    }
}