class Solution {
    public int minimumDistance(int[] nums) {

        if(nums.length<3)return -1;

        Map<Integer,List<Integer>> mp=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            mp.computeIfAbsent(nums[i],k -> new ArrayList<>()).add(i);
        }

        int min=Integer.MAX_VALUE;

        for(List<Integer> l: mp.values()){
            if(l.size()<3)continue;

            for (int i = 0; i <= l.size() - 3; i++) {
                int a = l.get(i);
                int b = l.get(i + 1);
                int c = l.get(i + 2);

                int dist = Math.abs(a - b) + Math.abs(b - c) + Math.abs(a - c);
                min = Math.min(min, dist);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}