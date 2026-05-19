class Solution {
    public int sumOfUnique(int[] nums) {
      Map<Integer,Integer> mp=new HashMap<>();
      int s=0;
      for (int n: nums){
        mp.put(n,mp.getOrDefault(n,0)+1);
      } 
      for(int key : mp.keySet()){
        if(mp.get(key)==1){
            s+=key;
        }
      }
      return s;
    }
}