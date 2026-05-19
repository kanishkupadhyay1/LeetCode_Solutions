class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int temp=Integer.MAX_VALUE;
        Set<Integer> s=new HashSet<>();
        for(int x: nums1){
            s.add(x);
        }

        for(int i=0;i<nums2.length;i++){
            if(nums2[i]<temp && s.contains(nums2[i])){
                temp=nums2[i];
            }
        }
    return temp==Integer.MAX_VALUE ? -1 : temp;
    }
}