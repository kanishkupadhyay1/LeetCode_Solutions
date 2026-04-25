class Solution {
    public int maxProduct(int[] nums) {
        Queue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                pq.offer((nums[i]-1)*(nums[j]-1));
                if(pq.size()>1)pq.poll();
            }
        }
        return pq.poll();
    }
}